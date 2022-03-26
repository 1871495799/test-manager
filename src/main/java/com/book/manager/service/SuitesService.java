package com.book.manager.service;

import com.book.manager.dao.SuitesMapper;
import com.book.manager.entity.Cases;
import com.book.manager.entity.Suites;
import com.book.manager.repos.SuitesRepository;
import com.book.manager.util.consts.Constants;
import com.book.manager.util.ro.PageIn;
import com.book.manager.util.vo.PageOut;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.book.manager.util.http.HttpBase.httpGet;
import static com.book.manager.util.http.HttpBase.httpPost;

/**
 * @Description 借阅管理
 */
@Service
public class SuitesService {

    @Autowired
    private SuitesRepository suitesRepository;

    @Autowired
    private SuitesMapper suitesMapper;

    @Autowired
    private CasesService casesService;

    @Autowired
    private UserService userService;

    /**
     * 添加
     * （添加事物）
     */
    @Transactional
    public Integer addSuite(Suites suites) {
        suitesRepository.saveAndFlush(suites);

        // 一切正常
        return Constants.OK;
    }

    /**
     * user id查询所有借阅信息
     */
    public List<Suites> findAllBorrowByUserId(Integer userId) {
        return suitesRepository.findBorrowByUserId(userId);
    }

//    /**
//     * user id查询所有 已借阅信息
//     */
//    public List<Suites> findBorrowsByUserIdAndRet(Integer userId, Integer ret) {
//        return borrowRepository.findBorrowsByUserIdAndRet(userId,ret);
//    }


    /**
     * 详情
     */
    public Suites findById(Integer id) {
        Optional<Suites> optional = suitesRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 编辑
     */
    public boolean updateSuites(Suites suites) {
        return suitesMapper.updateSuites(suites)>0;
    }


    /**
     * 编辑
     */
    public Suites updateBorrowByRepo(Suites borrow) {
        return suitesRepository.saveAndFlush(borrow);
    }

    /**
     * s删除
     */
    public void deleteSuite(Integer id) {
        suitesRepository.deleteById(id);
    }

//    /**
//     * 查询用户某一条借阅信息
//     * @param userId 用户id
//     * @param bookId 图书id
//     */
//    public Suites findBorrowByUserIdAndBookId(int userId, int bookId) {
//        return suitesMapper.findBorrowByUserIdAndBookId(userId,bookId);
//    }

//    /**
//     * 归还书籍, 使用事务保证 ACID
//     * @param userId 用户Id
//     * @param bookId 书籍id
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public void retBook(int userId,int bookId) {
//        // 用户可借数量加1
//        Users user = userService.findUserById(userId);
//        Integer size = user.getSize();
//        size++;
//        user.setSize(size);
//        userService.updateUser(user);
//
//
////        // 书籍库存加1
////        Cases cases = bookService.findBook(bookId);
////        Integer bookSize = cases.getSize();
////        bookSize++;
////        cases.setSize(bookSize);
////        bookService.updateBook(cases);
//        // 借阅记录改为已归还,删除记录
//        Suites borrow = this.findBorrowByUserIdAndBookId(userId, bookId);
////        suites.setRet(Constants.YES);
////        suites.setUpdateTime(new Date());
////        borrowMapper.updateBor(BeanUtil.beanToMap(suites))>0;
//        this.deleteBorrow(borrow.getId());
//    }



    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getSuiteList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Suites> list = suitesMapper.findSuiteListByLike(pageIn.getKeyword());
        PageInfo<Suites> pageInfo = new PageInfo<>(list);

//        List<Suites> bookOuts = new ArrayList<>();
//        for (Suites book : pageInfo.getList()) {
//            CasesOut out = new CasesOut();
//            BeanUtil.copyProperties(book,out);
//            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
//            bookOuts.add(out);
//        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(list);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }

    public void runSuite(Integer id) {
        Suites suites = findById(id);
        String caseId=suites.getCaseId();
        String arr []=caseId.split(",");

        for (String idx:arr) {
            Cases cases= casesService.findCase(Integer.parseInt(idx));
            String url=cases.getUrl();
            String methode=cases.getMethod();
            String json=cases.getJson();
            String author=cases.getAuthor();
            ResponseEntity<String> responseEntity=null;
            if(methode.equals("POST")){
                responseEntity= httpPost(url,json);
            }else {
                responseEntity= httpGet(url);
            }

            int status=responseEntity.getStatusCodeValue();
            if(status==200){
                String body=responseEntity.getBody();
                System.out.println(body);
            }



        }
    }
}
