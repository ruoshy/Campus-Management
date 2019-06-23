package cn.ousky.smartcampus.service;

import cn.ousky.smartcampus.entity.*;
import cn.ousky.smartcampus.ident.HandleIdent;
import cn.ousky.smartcampus.mapper.*;
import cn.ousky.smartcampus.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.*;

@Service
public class AdminService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ClasssMapper classsMapper;

    @Resource
    private MajorMapper majorMapper;

    @Resource
    private ClassroomMapper classroomMapper;

    @Resource
    private SubadministratorMapper subadministratorMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private CourseTableMapper courseTableMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private FileUtil fileUtil;

    public List<Department> findDepartmentBySchoolId(int schoolId) {
        return departmentMapper.findDepartmentBySchoolId(schoolId);
    }

    /**
     * 插入新系部
     *
     * @param department 系部信息
     * @return
     */
    public int insertDepartment(Department department) {
        return departmentMapper.insert(department);
    }

    /**
     * 更新系部信息
     *
     * @param department 系部信息
     * @return
     */
    public int updateDepartment(Department department) {
        return departmentMapper.update(department);
    }

    /**
     * 删除系部
     *
     * @param department 系部信息
     * @return
     */
    public int deleteDepartment(Department department) {
        return departmentMapper.delete(department);
    }

    /**
     * 查询班级信息
     *
     * @param classs 班级属性
     * @return
     */
    public List<Classs> selectClasss(Classs classs) {
        return classsMapper.select(classs);
    }

    /**
     * 查询系部所属班级
     *
     * @param departmentId 系部id
     * @return
     */
    public List<Classs> findClassAllByDepId(int departmentId) {
        return classsMapper.findAllByDepId(departmentId);
    }

    /**
     * 查询系部所属专业
     *
     * @param departmentId 系部id
     * @return
     */
    public List<Major> findMajorAllByDepId(int departmentId) {
        return majorMapper.findAllByDepId(departmentId);
    }

    /**
     * 插入班级
     *
     * @param classs 班级信息
     * @return
     */
    public HandleIdent insertClasss(Classs classs) {
        try {
            // 添加课程表
            CourseTable courseTable = new CourseTable();
            courseTable.setName(classs.getYear() + "" + classs.getNumber());
            courseTable.setDate(new Date());
            courseTableMapper.insert(courseTable);
            System.out.println(courseTable.getId());
            // 添加班级
            classs.setCourse_table_id(courseTable.getId());
            classsMapper.insert(classs);
            return HandleIdent.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HandleIdent.FAIL;
    }

    /**
     * 删除班级
     *
     * @param classs 班级信息
     * @return
     */
    public HandleIdent deleteClasss(Classs classs) {
        try {
            CourseTable courseTable = new CourseTable();
            courseTable.setId(classs.getCourse_table_id());
            User user = new User();
            user.setId(0);
            user.setClasss_id(classs.getId());
            Course course = new Course();
            course.setId(0);
            course.setCourse_table_id(classs.getCourse_table_id());
            // 删除学生
            userMapper.delete(user);
            // 删除班级
            classsMapper.delete(classs);
            // 删除课程
            courseMapper.delete(course);
            // 删除课程表
            courseTableMapper.delete(courseTable);
            return HandleIdent.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HandleIdent.FAIL;
    }

    /**
     * 插入专业
     *
     * @param major 专业信息
     * @return
     */
    public int insertMajor(Major major) {
        return majorMapper.insert(major);
    }

    /**
     * 删除专业
     *
     * @param major 专业信息
     * @return
     */
    public int deleteMajor(Major major) {
        return majorMapper.delete(major);
    }

    /**
     * 查询学校全部教室
     *
     * @param schoolId 教室信息
     * @return
     */
    public List<Classroom> findClassroomBySchoolId(int schoolId) {
        return classroomMapper.findAllBySchoolId(schoolId);
    }

    /**
     * 插入教室
     *
     * @param classroom 教室信息
     * @return
     */
    public int insertClassroom(Classroom classroom) {
        return classroomMapper.insert(classroom);
    }

    /**
     * 删除教室
     *
     * @param classroom 教室信息
     * @return
     */
    public int deleteClassroom(Classroom classroom) {
        return classroomMapper.delete(classroom);
    }

    /**
     * 更新教室信息
     *
     * @param classroom 教室信息
     * @return
     */
    public int updateClassroom(Classroom classroom) {
        return classroomMapper.update(classroom);
    }

    /**
     * 获取全部教学楼
     *
     * @param classroom 教室信息
     * @return
     */
    public List<Classroom> getClassroomAdress(Classroom classroom) {
        return classroomMapper.getAddress(classroom);
    }

    /**
     * @param classroom
     * @return
     */
    public Classroom findClassroomById(Classroom classroom) {
        return classroomMapper.findById(classroom.getId());
    }

    /**
     * 通过系部id查询教师账号信息
     *
     * @param departmentId 系部id
     * @return
     */
    public List<Subadministrator> findSubAdminByDepId(int departmentId) {
        return subadministratorMapper.findAllByDepId(departmentId);
    }

    /**
     * 添加教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    public int insertSubAdmin(Subadministrator subadministrator) {
        return subadministratorMapper.insert(subadministrator);
    }

    /**
     * 删除教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    public int deleteSubAdmin(Subadministrator subadministrator) {
        return subadministratorMapper.delete(subadministrator);
    }

    /**
     * 修改教师账号信息
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    public int updateSubAdmin(Subadministrator subadministrator) {
        return subadministratorMapper.update(subadministrator);
    }

    /**
     * 模糊查询教师账号信息
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    public List<Subadministrator> likeSubadminName(Subadministrator subadministrator) {
        List<Subadministrator> subadministrators = subadministratorMapper.likeName(subadministrator);

        return subadministrators;
    }

    /**
     * 通过id查询账号信息
     *
     * @param subadministrator
     * @return
     */
    public Subadministrator findSubadminById(Subadministrator subadministrator) {
        return subadministratorMapper.findById(subadministrator.getId());
    }

    /**
     * 查询学生信息
     *
     * @param user 学生信息
     * @return
     */
    public List<User> selectUser(User user) {
        return userMapper.select(user);
    }

    /**
     * 添加学生信息
     *
     * @param user 学生信息
     * @return
     */
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 修改学生信息
     *
     * @param user 学生信息
     * @return
     */
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    /**
     * 删除学生账号
     *
     * @param user 学生信息
     * @return
     */
    public int deleteUser(User user) {
        return userMapper.delete(user);
    }

    /**
     * 查询新闻
     *
     * @param news 新闻信息
     * @return
     */
    public List<News> selectNews(News news) {
        return newsMapper.select(news);
    }

    /**
     * 插入新闻
     *
     * @param news 新闻信息
     * @return
     */
    public int insertNews(HashMap<String, MultipartFile> hashMap, String data, News news) {
        String dirName = news.getAdministrators_id() + "@" + news.getName();
        // 新建文件夹
        if (!fileUtil.mkdir(dirName)) {
            return 0;
        }
        // 保存内容
        fileUtil.saveFile(data, dirName, "json.txt");
        // 保存图片
        Iterator<Map.Entry<String, MultipartFile>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            MultipartFile file = iterator.next().getValue();
            try {
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                fileUtil.save2File(bis, dirName, file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        news.setResource(dirName);
        return newsMapper.insert(news);
    }

    /**
     * 删除新闻
     *
     * @param news 新闻信息
     * @return
     */
    public int deleteNews(News news) {
        File file = new File(fileUtil.getPath() + news.getResource());
        fileUtil.delete(file);
        return newsMapper.delete(news);
    }

    /**
     * 更新新闻
     *
     * @param news 新闻信息
     * @return
     */
    public int updateNews(News news) {
        return newsMapper.update(news);
    }

    /**
     * 获取新闻具体信息
     *
     * @param news 新闻信息
     * @return
     */
    public String newInfo(News news) {
        StringBuilder sb = fileUtil.readFile(news.getAdministrators_id() + "@" + news.getName(), "json.txt");
        return sb.toString();
    }

    /**
     * 插入课程
     *
     * @param course 课程信息
     * @return
     */
    public int insertCourse(Course course) {
        return courseMapper.insert(course);
    }

    /**
     * 查询课程信息
     *
     * @param course
     * @return
     */
    public List<Course> selectCourse(Course course) {
        return courseMapper.select(course);
    }

    /**
     * 获取课程具体信息
     *
     * @param course
     * @return
     */
    public List<Course> selectcourseCount(Course course) {
        return courseMapper.findInfoByCourseTableId(course);
    }

    /**
     * 删除课程信息
     *
     * @param course
     * @return
     */
    public int deleteCourse(Course course) {
        return courseMapper.delete(course);
    }
}
