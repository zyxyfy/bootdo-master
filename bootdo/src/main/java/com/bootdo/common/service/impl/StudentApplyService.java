package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyApplyDao;
import com.bootdo.common.dao.StudentApplyDao;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.utils.BDException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:30
 */
@Service
public class StudentApplyService {
    private Logger logger = LoggerFactory.getLogger(StudentApplyService.class);
    @Autowired
    private StudentApplyDao studentApplyDao;

    /**
     * 查询学生申请记录
     * @param map
     * @return
     */
    public List<TeacherStudent> list(Map<String, Object> map) {
        logger.info("StudentApplyService.list()|map = {}",map.toString());
        List<TeacherStudent> teacherStudentList = studentApplyDao.queryTeacherStudent(map);
        logger.info("StudentApplyService.list()|teacherStudentList = {}",teacherStudentList.toString());
        return teacherStudentList;
    }

    /**
     * 学生申请记录条数
     * @param map
     * @return
     */
    public Integer countTotal(Map<String, Object> map) {
        logger.info("StudentApplyService.list()|map = {}",map.toString());
        Integer total = studentApplyDao.countTotal(map);
        logger.info("StudentApplyService.countTotal|total = {}",total);
        return total;
    }

    /**
     * 更新学生-老师连接状态
     * @param teacherStudent
     * @return
     */
    public Integer updateLinkStatus(TeacherStudent teacherStudent) {
        logger.info("StudentApplyService.updateLinkStatus()|map = {}",teacherStudent.toString());
        return studentApplyDao.updateLinkStatus(teacherStudent);
    }

}
