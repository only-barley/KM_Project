package com.company.lottomon.controller;

import com.company.lottomon.encrypt.AES256;
import com.company.lottomon.model.UserInfo;
import com.company.lottomon.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
@Component
public class AdminController {
    Logger log = Logger.getLogger(this.getClass());

    @Autowired
    @Resource(name = "adminService")
    private AdminService adminService;

    static private AES256 AES = new AES256("LOTTOMON01234567");

    /**
     * 관리자 페이지 intro 페이지 확인
     */
    /*@RequestMapping(value = {"/main.do","/" }, method = RequestMethod.GET)
    public String main(HttpServletRequest request, HttpSession session) {
        log.debug(session.getAttribute("user_id") + "세션 아이디입니다.");
        System.out.println(session.getAttribute("user_id") + "세션 아이디입니다.");

        return "admin/adminMain";
    }
*/
    /**
     * 관리자 페이지 user 페이지 확인
     */
    @RequestMapping(value = {"/user.do", "/main.do"})
    public String user(HttpServletRequest request, HttpSession session, org.springframework.ui.Model model) {
        System.out.println("신규 테스트");
        List<UserInfo> userInfo = adminService.selectUserInfo();

        model.addAttribute("userInfo",userInfo);

        return "/admin/manage";
    }
    /**
     * 관리자 페이지 lotto 관리 페이지 확인
     */
    @RequestMapping(value = "/lotto.do", method = RequestMethod.GET)
    public String lotto(HttpServletRequest request, HttpSession session) {

        return "admin/lotto";
    }

    /**
     * 관리자 페이지 lotto 데이터 업데이트
     */
    @SuppressWarnings("resource")
    @RequestMapping(value = "/lottoUpdate.do", method = RequestMethod.POST, consumes ={"multipart/form-data"})
    public @ResponseBody Object lottoUpdate(@RequestParam(value = "lottoFile") MultipartFile excelFile, HttpSession session, Model model) throws Exception{
        System.out.println("엑셀 파일 업로드 시작");

        try {
            adminService.insertLottoData(excelFile );

        }catch (Exception e){
            e.printStackTrace();
        }


        return "admin/lotto";
    }

    /**
     * 관리자 페이지 lotto 데이터 업데이트
     */
    @SuppressWarnings("resource")
    @RequestMapping(value = "/changeGrade.do", method = RequestMethod.POST)
    public @ResponseBody Object changeGrade(@RequestBody UserInfo userInfo, HttpSession session, Model model) throws Exception{
        System.out.println("고객 등급 변경");

        try {
            Map<String, Object> insMap = new HashMap<String, Object>();
            adminService.changeGrade(userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 1;
    }

}
