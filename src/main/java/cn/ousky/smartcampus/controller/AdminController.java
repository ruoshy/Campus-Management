package cn.ousky.smartcampus.controller;

import cn.ousky.smartcampus.entity.*;
import cn.ousky.smartcampus.ident.HandleIdent;
import cn.ousky.smartcampus.service.AdminService;
import cn.ousky.smartcampus.util.MessageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private MessageUtil messageUtil;
    @Resource
    private AdminService adminService;

    /**
     * 查询对应学校系部
     *
     * @param schoolId 学校id
     * @return
     */
    @RequestMapping("/depbd")
    public String findDepartmentBySchoolId(@RequestParam("id") Integer schoolId) {
        return JSON.toJSONString(adminService.findDepartmentBySchoolId(schoolId));
    }

    /**
     * 新增系部
     *
     * @param department 系部信息
     * @return
     */
    @RequestMapping(value = "/indep", method = RequestMethod.POST)
    public String insertDepartment(@RequestBody Department department) {
        int code = adminService.insertDepartment(department);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 更新系部信息
     *
     * @param department 系部信息
     * @return
     */
    @RequestMapping(value = "/updep", method = RequestMethod.POST)
    public String updateDepartment(@RequestBody Department department) {
        int code = adminService.updateDepartment(department);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 删除系部信息
     *
     * @param department 系部信息
     * @return
     */
    @RequestMapping(value = "/dldep", method = RequestMethod.POST)
    public String deleteDepartment(@RequestBody Department department) {
        int code = adminService.deleteDepartment(department);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 查询班级信息
     *
     * @param id              班级id
     * @param number          班级编号
     * @param year            年级
     * @param course_table_id 课程表id
     * @param major_id        专业id
     * @return
     */
    @RequestMapping(value = "/clssl")
    public String selectClasss(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "number", required = false) Integer number,
                               @RequestParam(value = "year", required = false) String year,
                               @RequestParam(value = "course_table_id", required = false) Integer course_table_id,
                               @RequestParam(value = "major_id", required = false) Integer major_id) {
        Classs classs = new Classs();
        classs.setId(id);
        classs.setNumber(number);
        classs.setYear(year);
        classs.setCourse_table_id(course_table_id);
        classs.setMajor_id(major_id);
        return JSON.toJSONString(adminService.selectClasss(classs));
    }

    /**
     * 查询系部所属班级
     *
     * @param departmentId 系部id
     * @return
     */
    @RequestMapping(value = "/clsbd")
    public String findClassAllByDepId(@RequestParam("id") Integer departmentId) {
        return JSON.toJSONString(adminService.findClassAllByDepId(departmentId));
    }

    /**
     * 查询系部所属专业
     *
     * @param departmentId 系部id
     * @return
     */
    @RequestMapping(value = "/majbd")
    public String findMajorAllByDepId(@RequestParam("id") Integer departmentId) {
        return JSON.toJSONString(adminService.findMajorAllByDepId(departmentId));
    }

    /**
     * 插入班级
     *
     * @param classs 班级信息
     * @return
     */
    @RequestMapping(value = "/incls", method = RequestMethod.POST)
    public String insertClasss(@RequestBody Classs classs) {
        HandleIdent handleIdent = adminService.insertClasss(classs);
        return JSON.toJSONString(messageUtil.getMessage(handleIdent));
    }

    /**
     * 删除班级
     *
     * @param classs 班级信息
     * @return
     */
    @RequestMapping(value = "/dlcls", method = RequestMethod.POST)
    public String deleteClasss(@RequestBody Classs classs) {
        HandleIdent handleIdent = adminService.deleteClasss(classs);
        return JSON.toJSONString(messageUtil.getMessage(handleIdent));
    }

    /**
     * 删除专业
     *
     * @param major 专业信息
     * @return
     */
    @RequestMapping(value = "/dlmaj", method = RequestMethod.POST)
    public String deleteMajor(@RequestBody Major major) {
        int code = adminService.deleteMajor(major);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 插入专业
     *
     * @param major 专业信息
     * @return
     */
    @RequestMapping(value = "/inmaj", method = RequestMethod.POST)
    public String insertMajor(@RequestBody Major major) {
        int code = adminService.insertMajor(major);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 查询学校全部教室
     *
     * @param id 学校id
     * @return
     */
    @RequestMapping(value = "/clrbd")
    public String find(@RequestParam("id") Integer id) {
        return JSON.toJSONString(adminService.findClassroomBySchoolId(id));
    }

    /**
     * 插入教室
     *
     * @param classroom 教室信息
     * @return
     */
    @RequestMapping(value = "/inclr", method = RequestMethod.POST)
    public String insertClassroom(@RequestBody Classroom classroom) {
        int code = adminService.insertClassroom(classroom);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 删除教室
     *
     * @param classroom 教室信息
     * @return
     */
    @RequestMapping(value = "/dlclr", method = RequestMethod.POST)
    public String deleteClassroom(@RequestBody Classroom classroom) {
        int code = adminService.deleteClassroom(classroom);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 更新教室信息
     *
     * @param classroom 教室信息
     * @return
     */
    @RequestMapping(value = "/upclr", method = RequestMethod.POST)
    public String updateClassroom(@RequestBody Classroom classroom) {
        int code = adminService.updateClassroom(classroom);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 获取全部教学楼
     *
     * @param schoolId 学校id
     * @return
     */
    @RequestMapping(value = "/clsabd")
    public String getClassAdress(@RequestParam("id") int schoolId) {
        Classroom classroom = new Classroom();
        classroom.setSchool_id(schoolId);
        return JSON.toJSONString(adminService.getClassroomAdress(classroom));
    }

    /**
     * 通过系部id查询教师账号信息
     *
     * @param departmentId 系部id
     * @return
     */
    @RequestMapping(value = "/suabd")
    public String findSubAdminByDepId(@RequestParam("id") Integer departmentId) {
        return JSON.toJSONString(adminService.findSubAdminByDepId(departmentId));
    }

    /**
     * 添加教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @RequestMapping(value = "/insua", method = RequestMethod.POST)
    public String insertSubAdmin(@RequestBody Subadministrator subadministrator) {
        int code = adminService.insertSubAdmin(subadministrator);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 删除教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @RequestMapping(value = "/dlsua", method = RequestMethod.POST)
    private String deleteSubAdmin(@RequestBody Subadministrator subadministrator) {
        int code = adminService.deleteSubAdmin(subadministrator);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 修改教师账号信息
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @RequestMapping(value = "/upsua", method = RequestMethod.POST)
    private String updateSubAdmin(@RequestBody Subadministrator subadministrator) {
        int code = adminService.updateSubAdmin(subadministrator);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 模糊查询教师账号
     *
     * @param name 姓名
     * @return
     */
    @RequestMapping(value = "/sualk")
    public String likeSubadminName(String name) {
        Subadministrator subadministrator = new Subadministrator();
        subadministrator.setName(name);
        return JSON.toJSONString(adminService.likeSubadminName(subadministrator));
    }

    /**
     * 查询学生信息
     *
     * @param id        学生id
     * @param name      姓名
     * @param user      学号
     * @param year      年级
     * @param school_id 学校id
     * @param classs_id 班级id
     * @return
     */
    @RequestMapping(value = "/usrsl")
    public String selectUser(@RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "user", required = false) String user,
                             @RequestParam(value = "year", required = false) String year,
                             @RequestParam(value = "school_id", required = false) Integer school_id,
                             @RequestParam(value = "classs_id", required = false) Integer classs_id) {
        User usr = new User();
        usr.setId(id);
        usr.setName(name);
        usr.setUser(user);
        usr.setYear(year);
        usr.setSchool_id(school_id);
        usr.setClasss_id(classs_id);
        return JSON.toJSONString(adminService.selectUser(usr));
    }

    /**
     * 添加学生信息
     *
     * @param user 学生信息
     * @return
     */
    @RequestMapping(value = "/inusr", method = RequestMethod.POST)
    private String insertUser(@RequestBody User user) {
        int code = adminService.insertUser(user);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 修改学生信息
     *
     * @param user 学生信息
     * @return
     */
    @RequestMapping(value = "/upusr", method = RequestMethod.POST)
    private String updateUser(@RequestBody User user) {
        int code = adminService.updateUser(user);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 删除学生账号
     *
     * @param user 学生信息
     * @return
     */
    @RequestMapping(value = "/dlusr", method = RequestMethod.POST)
    private String deleteUser(@RequestBody User user) {
        int code = adminService.deleteUser(user);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }


    /**
     * 查询新闻信息
     *
     * @param administrators_id 管理员id
     * @return
     */
    @RequestMapping(value = "/newsl")
    public String selectNews(Integer administrators_id) {
        News news = new News();
        if (administrators_id != null) {
            news.setAdministrators_id(administrators_id);
            return JSON.toJSONString(adminService.selectNews(news));
        }else {
            return JSON.toJSONString(news);
        }
    }

    /**
     * 插入新闻
     *
     * @param files 文件
     * @param name  标题
     * @param data  内容
     * @return
     */
    @RequestMapping(value = "/innew", method = RequestMethod.POST)
    public String insertNews(MultipartFile[] files, String name, String data, Integer administrators_id) {
        // 图片数据
        HashMap<String, MultipartFile> hashMap = new HashMap<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            if (!hashMap.containsKey(fileName)) {
                hashMap.put(fileName, file);
            }
        }
        // 填充数据
        News news = new News();
        news.setName(name);
        news.setAdministrators_id(administrators_id);
        news.setDate(new Date());
        adminService.insertNews(hashMap, data, news);
        return "";
    }

    /**
     * 修改新闻信息
     *
     * @param news 新闻信息
     * @return
     */
    @RequestMapping(value = "/upnew", method = RequestMethod.POST)
    public String updateNews(@RequestBody News news) {
        int code = adminService.updateNews(news);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 删除新闻
     *
     * @param news 新闻信息
     * @return
     */
    @RequestMapping(value = "/dlnew", method = RequestMethod.POST)
    public String deleteNews(@RequestBody News news) {
        int code = adminService.deleteNews(news);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 获取新闻具体信息
     *
     * @param administrators_id 管理员id
     * @param name              新闻名称
     * @return
     */
    @RequestMapping(value = "/ifnew")
    public String newInfo(Integer administrators_id, String name) {
        News news = new News();
        news.setName(name);
        news.setAdministrators_id(administrators_id);
        return adminService.newInfo(news);
    }

    /**
     * 插入课程
     *
     * @param course 课程信息
     * @return
     */
    @RequestMapping(value = "/incur", method = RequestMethod.POST)
    public String insertCourse(@RequestBody Course course) {
        int code = adminService.insertCourse(course);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }

    /**
     * 查询课程信息
     *
     * @param course_table_id 课程表id
     * @return
     */
    @RequestMapping(value = "/curbd")
    public String selectcourse(@RequestParam("course_table_id") Integer course_table_id) {
        Course course = new Course();
        course.setCourse_table_id(course_table_id);
        return JSON.toJSONString(adminService.selectCourse(course));
    }

    /**
     * @param course_table_id
     * @return
     */
    @RequestMapping(value = "/curcut")
    public String selectcourseCount(@RequestParam("course_table_id") Integer course_table_id) {
        Course course = new Course();
        course.setCourse_table_id(course_table_id);
        return JSON.toJSONString(adminService.selectcourseCount(course), SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 删除课程信息
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "dlcur", method = RequestMethod.POST)
    public String deleteCourse(@RequestBody Course course) {
        int code = adminService.deleteCourse(course);
        return JSON.toJSONString(messageUtil.getMessage(code));
    }
}
