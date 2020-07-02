package cn.threeGroup.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
public class ErrorTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrorTopicExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameIsNull() {
            addCriterion("examination_name is null");
            return (Criteria) this;
        }

        public Criteria andExaminationNameIsNotNull() {
            addCriterion("examination_name is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationNameEqualTo(String value) {
            addCriterion("examination_name =", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameNotEqualTo(String value) {
            addCriterion("examination_name <>", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameGreaterThan(String value) {
            addCriterion("examination_name >", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameGreaterThanOrEqualTo(String value) {
            addCriterion("examination_name >=", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameLessThan(String value) {
            addCriterion("examination_name <", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameLessThanOrEqualTo(String value) {
            addCriterion("examination_name <=", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameLike(String value) {
            addCriterion("examination_name like", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameNotLike(String value) {
            addCriterion("examination_name not like", value, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameIn(List<String> values) {
            addCriterion("examination_name in", values, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameNotIn(List<String> values) {
            addCriterion("examination_name not in", values, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameBetween(String value1, String value2) {
            addCriterion("examination_name between", value1, value2, "examinationName");
            return (Criteria) this;
        }

        public Criteria andExaminationNameNotBetween(String value1, String value2) {
            addCriterion("examination_name not between", value1, value2, "examinationName");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherIsNull() {
            addCriterion("judge_teacher is null");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherIsNotNull() {
            addCriterion("judge_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherEqualTo(String value) {
            addCriterion("judge_teacher =", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherNotEqualTo(String value) {
            addCriterion("judge_teacher <>", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherGreaterThan(String value) {
            addCriterion("judge_teacher >", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("judge_teacher >=", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherLessThan(String value) {
            addCriterion("judge_teacher <", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherLessThanOrEqualTo(String value) {
            addCriterion("judge_teacher <=", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherLike(String value) {
            addCriterion("judge_teacher like", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherNotLike(String value) {
            addCriterion("judge_teacher not like", value, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherIn(List<String> values) {
            addCriterion("judge_teacher in", values, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherNotIn(List<String> values) {
            addCriterion("judge_teacher not in", values, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherBetween(String value1, String value2) {
            addCriterion("judge_teacher between", value1, value2, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andJudgeTeacherNotBetween(String value1, String value2) {
            addCriterion("judge_teacher not between", value1, value2, "judgeTeacher");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNull() {
            addCriterion("topic_type is null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNotNull() {
            addCriterion("topic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeEqualTo(String value) {
            addCriterion("topic_type =", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotEqualTo(String value) {
            addCriterion("topic_type <>", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThan(String value) {
            addCriterion("topic_type >", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("topic_type >=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThan(String value) {
            addCriterion("topic_type <", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThanOrEqualTo(String value) {
            addCriterion("topic_type <=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLike(String value) {
            addCriterion("topic_type like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotLike(String value) {
            addCriterion("topic_type not like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIn(List<String> values) {
            addCriterion("topic_type in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotIn(List<String> values) {
            addCriterion("topic_type not in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeBetween(String value1, String value2) {
            addCriterion("topic_type between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotBetween(String value1, String value2) {
            addCriterion("topic_type not between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Long value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Long value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Long value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Long value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Long value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Long> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Long> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Long value1, Long value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Long value1, Long value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andRightErrorIsNull() {
            addCriterion("right_error is null");
            return (Criteria) this;
        }

        public Criteria andRightErrorIsNotNull() {
            addCriterion("right_error is not null");
            return (Criteria) this;
        }

        public Criteria andRightErrorEqualTo(Byte value) {
            addCriterion("right_error =", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorNotEqualTo(Byte value) {
            addCriterion("right_error <>", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorGreaterThan(Byte value) {
            addCriterion("right_error >", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorGreaterThanOrEqualTo(Byte value) {
            addCriterion("right_error >=", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorLessThan(Byte value) {
            addCriterion("right_error <", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorLessThanOrEqualTo(Byte value) {
            addCriterion("right_error <=", value, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorIn(List<Byte> values) {
            addCriterion("right_error in", values, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorNotIn(List<Byte> values) {
            addCriterion("right_error not in", values, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorBetween(Byte value1, Byte value2) {
            addCriterion("right_error between", value1, value2, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightErrorNotBetween(Byte value1, Byte value2) {
            addCriterion("right_error not between", value1, value2, "rightError");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNull() {
            addCriterion("right_answer is null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIsNotNull() {
            addCriterion("right_answer is not null");
            return (Criteria) this;
        }

        public Criteria andRightAnswerEqualTo(String value) {
            addCriterion("right_answer =", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotEqualTo(String value) {
            addCriterion("right_answer <>", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThan(String value) {
            addCriterion("right_answer >", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("right_answer >=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThan(String value) {
            addCriterion("right_answer <", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLessThanOrEqualTo(String value) {
            addCriterion("right_answer <=", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerLike(String value) {
            addCriterion("right_answer like", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotLike(String value) {
            addCriterion("right_answer not like", value, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerIn(List<String> values) {
            addCriterion("right_answer in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotIn(List<String> values) {
            addCriterion("right_answer not in", values, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerBetween(String value1, String value2) {
            addCriterion("right_answer between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andRightAnswerNotBetween(String value1, String value2) {
            addCriterion("right_answer not between", value1, value2, "rightAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerIsNull() {
            addCriterion("personal_answer is null");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerIsNotNull() {
            addCriterion("personal_answer is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerEqualTo(String value) {
            addCriterion("personal_answer =", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerNotEqualTo(String value) {
            addCriterion("personal_answer <>", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerGreaterThan(String value) {
            addCriterion("personal_answer >", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("personal_answer >=", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerLessThan(String value) {
            addCriterion("personal_answer <", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerLessThanOrEqualTo(String value) {
            addCriterion("personal_answer <=", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerLike(String value) {
            addCriterion("personal_answer like", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerNotLike(String value) {
            addCriterion("personal_answer not like", value, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerIn(List<String> values) {
            addCriterion("personal_answer in", values, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerNotIn(List<String> values) {
            addCriterion("personal_answer not in", values, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerBetween(String value1, String value2) {
            addCriterion("personal_answer between", value1, value2, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andPersonalAnswerNotBetween(String value1, String value2) {
            addCriterion("personal_answer not between", value1, value2, "personalAnswer");
            return (Criteria) this;
        }

        public Criteria andAnlysisIsNull() {
            addCriterion("anlysis is null");
            return (Criteria) this;
        }

        public Criteria andAnlysisIsNotNull() {
            addCriterion("anlysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnlysisEqualTo(String value) {
            addCriterion("anlysis =", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisNotEqualTo(String value) {
            addCriterion("anlysis <>", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisGreaterThan(String value) {
            addCriterion("anlysis >", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisGreaterThanOrEqualTo(String value) {
            addCriterion("anlysis >=", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisLessThan(String value) {
            addCriterion("anlysis <", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisLessThanOrEqualTo(String value) {
            addCriterion("anlysis <=", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisLike(String value) {
            addCriterion("anlysis like", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisNotLike(String value) {
            addCriterion("anlysis not like", value, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisIn(List<String> values) {
            addCriterion("anlysis in", values, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisNotIn(List<String> values) {
            addCriterion("anlysis not in", values, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisBetween(String value1, String value2) {
            addCriterion("anlysis between", value1, value2, "anlysis");
            return (Criteria) this;
        }

        public Criteria andAnlysisNotBetween(String value1, String value2) {
            addCriterion("anlysis not between", value1, value2, "anlysis");
            return (Criteria) this;
        }

        public Criteria andRightScoreIsNull() {
            addCriterion("right_score is null");
            return (Criteria) this;
        }

        public Criteria andRightScoreIsNotNull() {
            addCriterion("right_score is not null");
            return (Criteria) this;
        }

        public Criteria andRightScoreEqualTo(Float value) {
            addCriterion("right_score =", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreNotEqualTo(Float value) {
            addCriterion("right_score <>", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreGreaterThan(Float value) {
            addCriterion("right_score >", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("right_score >=", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreLessThan(Float value) {
            addCriterion("right_score <", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreLessThanOrEqualTo(Float value) {
            addCriterion("right_score <=", value, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreIn(List<Float> values) {
            addCriterion("right_score in", values, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreNotIn(List<Float> values) {
            addCriterion("right_score not in", values, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreBetween(Float value1, Float value2) {
            addCriterion("right_score between", value1, value2, "rightScore");
            return (Criteria) this;
        }

        public Criteria andRightScoreNotBetween(Float value1, Float value2) {
            addCriterion("right_score not between", value1, value2, "rightScore");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Float value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Float value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Float value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Float value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Float value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Float> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Float> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Float value1, Float value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Float value1, Float value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Byte value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Byte value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Byte value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Byte value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Byte value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Byte value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Byte> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Byte> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Byte value1, Byte value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Byte value1, Byte value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}