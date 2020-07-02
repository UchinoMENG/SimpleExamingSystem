package cn.threeGroup.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
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

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNull() {
            addCriterion("subject_name is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNotNull() {
            addCriterion("subject_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEqualTo(String value) {
            addCriterion("subject_name =", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotEqualTo(String value) {
            addCriterion("subject_name <>", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThan(String value) {
            addCriterion("subject_name >", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("subject_name >=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThan(String value) {
            addCriterion("subject_name <", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThanOrEqualTo(String value) {
            addCriterion("subject_name <=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLike(String value) {
            addCriterion("subject_name like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotLike(String value) {
            addCriterion("subject_name not like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIn(List<String> values) {
            addCriterion("subject_name in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotIn(List<String> values) {
            addCriterion("subject_name not in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameBetween(String value1, String value2) {
            addCriterion("subject_name between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotBetween(String value1, String value2) {
            addCriterion("subject_name not between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectCententIsNull() {
            addCriterion("subject_centent is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCententIsNotNull() {
            addCriterion("subject_centent is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCententEqualTo(String value) {
            addCriterion("subject_centent =", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententNotEqualTo(String value) {
            addCriterion("subject_centent <>", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententGreaterThan(String value) {
            addCriterion("subject_centent >", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententGreaterThanOrEqualTo(String value) {
            addCriterion("subject_centent >=", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententLessThan(String value) {
            addCriterion("subject_centent <", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententLessThanOrEqualTo(String value) {
            addCriterion("subject_centent <=", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententLike(String value) {
            addCriterion("subject_centent like", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententNotLike(String value) {
            addCriterion("subject_centent not like", value, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententIn(List<String> values) {
            addCriterion("subject_centent in", values, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententNotIn(List<String> values) {
            addCriterion("subject_centent not in", values, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententBetween(String value1, String value2) {
            addCriterion("subject_centent between", value1, value2, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectCententNotBetween(String value1, String value2) {
            addCriterion("subject_centent not between", value1, value2, "subjectCentent");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsIsNull() {
            addCriterion("subject_options is null");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsIsNotNull() {
            addCriterion("subject_options is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsEqualTo(String value) {
            addCriterion("subject_options =", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsNotEqualTo(String value) {
            addCriterion("subject_options <>", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsGreaterThan(String value) {
            addCriterion("subject_options >", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("subject_options >=", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsLessThan(String value) {
            addCriterion("subject_options <", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsLessThanOrEqualTo(String value) {
            addCriterion("subject_options <=", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsLike(String value) {
            addCriterion("subject_options like", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsNotLike(String value) {
            addCriterion("subject_options not like", value, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsIn(List<String> values) {
            addCriterion("subject_options in", values, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsNotIn(List<String> values) {
            addCriterion("subject_options not in", values, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsBetween(String value1, String value2) {
            addCriterion("subject_options between", value1, value2, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectOptionsNotBetween(String value1, String value2) {
            addCriterion("subject_options not between", value1, value2, "subjectOptions");
            return (Criteria) this;
        }

        public Criteria andSubjectValueIsNull() {
            addCriterion("subject_value is null");
            return (Criteria) this;
        }

        public Criteria andSubjectValueIsNotNull() {
            addCriterion("subject_value is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectValueEqualTo(Double value) {
            addCriterion("subject_value =", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueNotEqualTo(Double value) {
            addCriterion("subject_value <>", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueGreaterThan(Double value) {
            addCriterion("subject_value >", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueGreaterThanOrEqualTo(Double value) {
            addCriterion("subject_value >=", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueLessThan(Double value) {
            addCriterion("subject_value <", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueLessThanOrEqualTo(Double value) {
            addCriterion("subject_value <=", value, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueIn(List<Double> values) {
            addCriterion("subject_value in", values, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueNotIn(List<Double> values) {
            addCriterion("subject_value not in", values, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueBetween(Double value1, Double value2) {
            addCriterion("subject_value between", value1, value2, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectValueNotBetween(Double value1, Double value2) {
            addCriterion("subject_value not between", value1, value2, "subjectValue");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerIsNull() {
            addCriterion("subject_answer is null");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerIsNotNull() {
            addCriterion("subject_answer is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerEqualTo(String value) {
            addCriterion("subject_answer =", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerNotEqualTo(String value) {
            addCriterion("subject_answer <>", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerGreaterThan(String value) {
            addCriterion("subject_answer >", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("subject_answer >=", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerLessThan(String value) {
            addCriterion("subject_answer <", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerLessThanOrEqualTo(String value) {
            addCriterion("subject_answer <=", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerLike(String value) {
            addCriterion("subject_answer like", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerNotLike(String value) {
            addCriterion("subject_answer not like", value, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerIn(List<String> values) {
            addCriterion("subject_answer in", values, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerNotIn(List<String> values) {
            addCriterion("subject_answer not in", values, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerBetween(String value1, String value2) {
            addCriterion("subject_answer between", value1, value2, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andSubjectAnswerNotBetween(String value1, String value2) {
            addCriterion("subject_answer not between", value1, value2, "subjectAnswer");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisIsNull() {
            addCriterion("answer_analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisIsNotNull() {
            addCriterion("answer_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisEqualTo(String value) {
            addCriterion("answer_analysis =", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisNotEqualTo(String value) {
            addCriterion("answer_analysis <>", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisGreaterThan(String value) {
            addCriterion("answer_analysis >", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("answer_analysis >=", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisLessThan(String value) {
            addCriterion("answer_analysis <", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisLessThanOrEqualTo(String value) {
            addCriterion("answer_analysis <=", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisLike(String value) {
            addCriterion("answer_analysis like", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisNotLike(String value) {
            addCriterion("answer_analysis not like", value, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisIn(List<String> values) {
            addCriterion("answer_analysis in", values, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisNotIn(List<String> values) {
            addCriterion("answer_analysis not in", values, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisBetween(String value1, String value2) {
            addCriterion("answer_analysis between", value1, value2, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andAnswerAnalysisNotBetween(String value1, String value2) {
            addCriterion("answer_analysis not between", value1, value2, "answerAnalysis");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeIsNull() {
            addCriterion("subject_type_code is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeIsNotNull() {
            addCriterion("subject_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeEqualTo(String value) {
            addCriterion("subject_type_code =", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeNotEqualTo(String value) {
            addCriterion("subject_type_code <>", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeGreaterThan(String value) {
            addCriterion("subject_type_code >", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("subject_type_code >=", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeLessThan(String value) {
            addCriterion("subject_type_code <", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("subject_type_code <=", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeLike(String value) {
            addCriterion("subject_type_code like", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeNotLike(String value) {
            addCriterion("subject_type_code not like", value, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeIn(List<String> values) {
            addCriterion("subject_type_code in", values, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeNotIn(List<String> values) {
            addCriterion("subject_type_code not in", values, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeBetween(String value1, String value2) {
            addCriterion("subject_type_code between", value1, value2, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeCodeNotBetween(String value1, String value2) {
            addCriterion("subject_type_code not between", value1, value2, "subjectTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeIsNull() {
            addCriterion("course_type_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeIsNotNull() {
            addCriterion("course_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeEqualTo(String value) {
            addCriterion("course_type_code =", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeNotEqualTo(String value) {
            addCriterion("course_type_code <>", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeGreaterThan(String value) {
            addCriterion("course_type_code >", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type_code >=", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeLessThan(String value) {
            addCriterion("course_type_code <", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("course_type_code <=", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeLike(String value) {
            addCriterion("course_type_code like", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeNotLike(String value) {
            addCriterion("course_type_code not like", value, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeIn(List<String> values) {
            addCriterion("course_type_code in", values, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeNotIn(List<String> values) {
            addCriterion("course_type_code not in", values, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeBetween(String value1, String value2) {
            addCriterion("course_type_code between", value1, value2, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andCourseTypeCodeNotBetween(String value1, String value2) {
            addCriterion("course_type_code not between", value1, value2, "courseTypeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeIsNull() {
            addCriterion("knowledge_code is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeIsNotNull() {
            addCriterion("knowledge_code is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeEqualTo(String value) {
            addCriterion("knowledge_code =", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeNotEqualTo(String value) {
            addCriterion("knowledge_code <>", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeGreaterThan(String value) {
            addCriterion("knowledge_code >", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_code >=", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeLessThan(String value) {
            addCriterion("knowledge_code <", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeLessThanOrEqualTo(String value) {
            addCriterion("knowledge_code <=", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeLike(String value) {
            addCriterion("knowledge_code like", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeNotLike(String value) {
            addCriterion("knowledge_code not like", value, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeIn(List<String> values) {
            addCriterion("knowledge_code in", values, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeNotIn(List<String> values) {
            addCriterion("knowledge_code not in", values, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeBetween(String value1, String value2) {
            addCriterion("knowledge_code between", value1, value2, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andKnowledgeCodeNotBetween(String value1, String value2) {
            addCriterion("knowledge_code not between", value1, value2, "knowledgeCode");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyIsNull() {
            addCriterion("subject_difficultly is null");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyIsNotNull() {
            addCriterion("subject_difficultly is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyEqualTo(Long value) {
            addCriterion("subject_difficultly =", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyNotEqualTo(Long value) {
            addCriterion("subject_difficultly <>", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyGreaterThan(Long value) {
            addCriterion("subject_difficultly >", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_difficultly >=", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyLessThan(Long value) {
            addCriterion("subject_difficultly <", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyLessThanOrEqualTo(Long value) {
            addCriterion("subject_difficultly <=", value, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyIn(List<Long> values) {
            addCriterion("subject_difficultly in", values, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyNotIn(List<Long> values) {
            addCriterion("subject_difficultly not in", values, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyBetween(Long value1, Long value2) {
            addCriterion("subject_difficultly between", value1, value2, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andSubjectDifficultlyNotBetween(Long value1, Long value2) {
            addCriterion("subject_difficultly not between", value1, value2, "subjectDifficultly");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNull() {
            addCriterion("create_account is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNotNull() {
            addCriterion("create_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountEqualTo(String value) {
            addCriterion("create_account =", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotEqualTo(String value) {
            addCriterion("create_account <>", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThan(String value) {
            addCriterion("create_account >", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("create_account >=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThan(String value) {
            addCriterion("create_account <", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("create_account <=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLike(String value) {
            addCriterion("create_account like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotLike(String value) {
            addCriterion("create_account not like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIn(List<String> values) {
            addCriterion("create_account in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotIn(List<String> values) {
            addCriterion("create_account not in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountBetween(String value1, String value2) {
            addCriterion("create_account between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotBetween(String value1, String value2) {
            addCriterion("create_account not between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
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