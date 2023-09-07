package com.bsus.controller;

import com.bsus.mapper.InfoMapper;
import com.bsus.service.ScoreService;
import com.bsus.service.UserService;
import com.bsus.util.DataUtil;
import com.bsus.vo.BaseUser;
import com.bsus.vo.Info;
import com.bsus.vo.School;
import com.bsus.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
    用户注册界面
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/lead.html")
    public String lead() {
        return "lead";
    }


    @RequestMapping("/back")
    public String back() {
        return "back";
    }

    @RequestMapping("/managelead.html")
    public String navigaty() {
        return "managelead";
    }

    @RequestMapping("/chuangxin")
    public String chuangxin() { return "chuangxin";
    }
    @RequestMapping("/tab_base")
    public String tab_base() { return "tab_base";
    }

    @RequestMapping("/computer")
    public String computer() { return "computer";
    }
    @RequestMapping("/getSelect")
    public String getSelect() { return "selectPhy";
    }
    @RequestMapping("/check")
    public String check() { return "check";
    }
    @Autowired
    private InfoMapper mapper;
    @RequestMapping("/editzhiyuan")
    public String editzhiyuan(Model model) {
        List<Info> select = mapper.select();
        model.addAttribute("listSchool",select);

        return "editzhiyuan";
    }

//    @RequestMapping("/getInfo")
//    public String getInfo( Model model) {
//        model.addAttribute("msg", "用户已存在");
//        return "info";
//    }

    @GetMapping("/role")
    public String role(String role, Model model) {
        System.out.println(role);
        if ("1".equals(role)) {
            model.addAttribute("role", "STUDENT LOGIN");
            return "login";
        } else if ("2".equals(role)) {
            model.addAttribute("role", "ADMINISTRATOR LOGIN");
            return "login";
        } else {
            return "check";
        }

//        if (role.equals("1")){
//            return "login";
//        } else if (role.equals("2")) {
//            PageHelper.startPage(1, 10);
//            List<BaseUser> list = userService.selectUsers();
//            System.out.println(list);
//            model.addAttribute("listUsers", list);
//            PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
//            model.addAttribute("page", pageInfo);
//            return "user";
//        }else {
//            return "check";
//        }


//        return "editUser";
    }


    /*
   用户登录界面
    */
    @RequestMapping(value = "/login", method = {RequestMethod.POST}
    )
    public String login(String username, String password, Model model) {
//        if (role.equals("") || null == role) {
//            return "check";
//        }

        User user = userService.loginByUsername(username);
        if (user == null) {
            model.addAttribute("msg", "用户名不存在");
//            System.out.println("没有查出来");
            return "login.html";
        } else {
            String password1 = user.getPassword();
            if (password.equals(password1)) {
                if (!username.equals("admin")) {
                    model.addAttribute("username", username);
                    return "redirect:/lead.html";
                } else {
                    model.addAttribute("username", username);
                    return "redirect:/managelead.html";
                }
            } else {
                model.addAttribute("msg", "密码不正确");
                return "login.html";
            }
        }


    }


    /*
     用户注册界面
     */
    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password, Model model) {
        System.out.println(username);
        System.out.println(password);
        try {


            if (userService.addUser(username, password)) {
//            System.out.println("添加成功！！！");
                model.addAttribute("msg", "注册成功，请登录");
                return "login";
            } else {
                return "register";
            }
        } catch (Exception e) {
            model.addAttribute("msg", "用户已存在");
            return "register";
        }
//        return "redirect:/index.html";
    }


    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/getUser")
    public String getUser(Model model,
                          @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<BaseUser> list = userService.selectUsers();
        System.out.println(list);
        model.addAttribute("listUsers", list);
        PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
        model.addAttribute("page", pageInfo);
        return "user";

    }


    @RequestMapping("/getData")
    public String getData(Model model,
                          @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
//        List<BaseUser> list = userService.selectUsers();
        DataUtil.list = new ArrayList<School>();
        DataUtil.ids = new ArrayList<>();
        School school = new School();
        school.setId(1);
        DataUtil.ids.add(1);
        school.setName("北京大学");
        school.setScore(700);
        school.setStage("985");
        school.setAddr("北京");
        DataUtil.list.add(school);
        School school2 = new School();
        DataUtil.ids.add(2);
        school2.setId(2);
        school2.setName("清华大学");
        school2.setScore(700);
        school2.setStage("985");
        school2.setAddr("北京");
        DataUtil.list.add(school2);
        School school3 = new School();
        DataUtil.ids.add(3);
        school3.setId(3);
        school3.setName("复旦大学");
        school3.setScore(610);
        school3.setStage("985");
        school3.setAddr("上海");
        DataUtil.list.add(school3);
        School school4 = new School();
        DataUtil.ids.add(4);
        school3.setId(4);
        school3.setName("河北大学");
        school3.setScore(600);
        school3.setStage("一本");
        school3.setAddr("保定");
        DataUtil.list.add(school4);
        School school5 = new School();
        DataUtil.ids.add(5);
        school3.setId(5);
        school3.setName("河北工业大学");
        school3.setScore(630);
        school3.setStage("211");
        school3.setAddr("天津");
        DataUtil.list.add(school5);
        School school6 = new School();
        DataUtil.ids.add(6);
        school3.setId(6);
        school3.setName("石河子大学");
        school3.setScore(620);
        school3.setStage("211");
        school3.setAddr("新疆");
        DataUtil.list.add(school6);

        System.out.println(DataUtil.list);
        model.addAttribute("listSchool", DataUtil.list);
        PageInfo<School> pageInfo = new PageInfo<>(DataUtil.list);
        model.addAttribute("page", pageInfo);
        return "data";

    }

    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.queryUserById(id));
        return "editUser";
    }

    @GetMapping("/editSchool/{id}")
    public String editSchool(@PathVariable Integer id, Model model) {
        int top = 0;
        for (int i = 0; i < DataUtil.list.size(); i++) {
            if (DataUtil.list.get(i).getId().equals(id)) {
                top = i;
                break;
            }
        }
        School school = DataUtil.list.get(top);
        model.addAttribute("school", school);
        return "editSchool";
    }

    /* 新增操作 */
    @GetMapping("/update")
    public String toUpdate(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "editUser";
    }

    /* 新增操作 */
    @GetMapping("/updateSchool")
    public String editSchool(Model model) {
        School school = new School();
        model.addAttribute("school", school);
        return "editSchool";
    }


    @PostMapping("/edit")
    public String edit(User user, RedirectAttributes attributes, Model model) {
        int i = userService.selectUserByName(user.getUsername());
        /* 根据id的是否为null判断新增还是修改操作，null为新增，不为null为修改 */
        Integer id = user.getId();

        PageHelper.startPage(1, 10);

        /* 修改用户 */
        if (id != null) {
            /* 用户名存在 */
            if (i >= 1) {
                boolean b = userService.updateUser(user);
                if (b) {
//                    attributes.addFlashAttribute("message", " 更新用户成功");
                    model.addAttribute("message", " 更新用户成功");
//                    return "redirect:/";
//                    return "user";
                } else {
//                    attributes.addFlashAttribute("message", "更新用户失败");
                    model.addAttribute("message", "更新用户失败");
//                    return "redirect:/";
//                    return "user";
                }
                List<BaseUser> list = userService.selectUsers();
                System.out.println(list);
                model.addAttribute("listUsers", list);
                PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
                model.addAttribute("page", pageInfo);
                return "user";
            } else {
                attributes.addFlashAttribute("message", "该用户名已存在");
                return "redirect:/edit/" + user.getId();
            }
            // 新增用户
        } else {
            if (i == 0) {
                boolean b = userService.addUserVo(user);
                if (b) {
//                    attributes.addFlashAttribute("message", " 新增用户成功");
                    model.addAttribute("message", " 新增用户成功");
//                    return "redirect:/";
//                    return "user";
                } else {
//                    attributes.addFlashAttribute("message", "新增用户失败");
                    model.addAttribute("message", "新增用户失败");
//                    return "redirect:/";
//                    return "user";
                }
            } else {
//                attributes.addFlashAttribute("message", "该用户名已存在");
                model.addAttribute("message", "该用户名已存在");
//                return "redirect:/";
//                return "user";
            }
            List<BaseUser> list = userService.selectUsers();
            System.out.println(list);
            model.addAttribute("listUsers", list);
            PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
            model.addAttribute("page", pageInfo);
            return "user";
        }
    }


    @PostMapping("/add")
    public String add(School school, RedirectAttributes attributes, Model model) {
        int top = 0;
        for (int i = 0; i < DataUtil.list.size(); i++) {
            if (DataUtil.list.get(i).getName().equals(school.getName())) {
                top = i + 1;
            }
        }
        if (top >= 1 && school.getId()==null) {
            model.addAttribute("message", "学校已存在");
        } else if (top >= 1 && school.getId()!=null) {
            DataUtil.list.remove(top-1);
            DataUtil.list.add(school);
        }else {
            Collections.sort(DataUtil.ids);
            int id = DataUtil.ids.get(DataUtil.ids.size() - 2) + 2;
            DataUtil.ids.add(id);
            school.setId(id);
            DataUtil.list.add(school);
        }


//        List<BaseUser> list = userService.selectUsers();
//        System.out.println(list);
//        model.addAttribute("listUsers", list);
//        PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
        model.addAttribute("listSchool", DataUtil.list);
        PageInfo<School> pageInfo = new PageInfo<>(DataUtil.list);
        model.addAttribute("page", pageInfo);

        return "data";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes, Model model) {
        PageHelper.startPage(1, 10);
        boolean b = userService.deleteUserById(id);
        if (b) {
//            attributes.addFlashAttribute("message", "删除用户成功");
            model.addAttribute("message", "删除用户成功");
//            return "redirect:/";
        } else {
//            attributes.addFlashAttribute("message", "删除用户失败");
            model.addAttribute("message", "删除用户失败");
//            return "redirect:/";
        }
        List<BaseUser> list = userService.selectUsers();
        System.out.println(list);
        model.addAttribute("listUsers", list);
        PageInfo<BaseUser> pageInfo = new PageInfo<>(list);
        model.addAttribute("page", pageInfo);
        return "user";
    }

    @GetMapping("/deleteSchool/{id}")
    public String deleteSchool(@PathVariable("id") Integer id, Model model) {
        PageHelper.startPage(1, 10);

        int top = 0;
        for (int i = 0; i < DataUtil.list.size(); i++) {
            if (DataUtil.list.get(i).getId().equals(id)) {
//                top = i+1;
                top = i;
            }
        }
        School school = DataUtil.list.remove(top);
        DataUtil.ids.remove(top);

        if (school != null) {
//            attributes.addFlashAttribute("message", "删除用户成功");
            model.addAttribute("message", "删除学校成功");
//            return "redirect:/";
        } else {
//            attributes.addFlashAttribute("message", "删除用户失败");
            model.addAttribute("message", "删除学校失败");
//            return "redirect:/";
        }
//        List<BaseUser> list = userService.selectUsers();
//        System.out.println(list);
//        model.addAttribute("listUsers", list);
//        PageInfo<BaseUser> pageInfo = new PageInfo<>(list);

        model.addAttribute("listSchool", DataUtil.list);
        PageInfo<School> pageInfo = new PageInfo<>(DataUtil.list);
        model.addAttribute("page", pageInfo);
        return "data";
    }

}
