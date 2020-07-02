package cn.threeGroup.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
public class SubjectPinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectPinExample() {
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

        public Criteria andPinIdIsNull() {
            addCriterion("pin_id is null");
            return (Criteria) this;
        }

        public Criteria andPinIdIsNotNull() {
            addCriterion("pin_id is not null");
            return (Criteria) this;
        }

        public Criteria andPinIdEqualTo(Long value) {
            addCriterion("pin_id =", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdNotEqualTo(Long value) {
            addCriterion("pin_id <>", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdGreaterThan(Long value) {
            addCriterion("pin_id >", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pin_id >=", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdLessThan(Long value) {
            addCriterion("pin_id <", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdLessThanOrEqualTo(Long value) {
            addCriterion("pin_id <=", value, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdIn(List<Long> values) {
            addCriterion("pin_id in", values, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdNotIn(List<Long> values) {
            addCriterion("pin_id not in", values, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdBetween(Long value1, Long value2) {
            addCriterion("pin_id between", value1, value2, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinIdNotBetween(Long value1, Long value2) {
            addCriterion("pin_id not between", value1, value2, "pinId");
            return (Criteria) this;
        }

        public Criteria andPinNameIsNull() {
            addCriterion("pin_name is null");
            return (Criteria) this;
        }

        public Criteria andPinNameIsNotNull() {
            addCriterion("pin_name is not null");
            return (Criteria) this;
        }

        public Criteria andPinNameEqualTo(String value) {
            addCriterion("pin_name =", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameNotEqualTo(String value) {
            addCriterion("pin_name <>", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameGreaterThan(String value) {
            addCriterion("pin_name >", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameGreaterThanOrEqualTo(String value) {
            addCriterion("pin_name >=", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameLessThan(String value) {
            addCriterion("pin_name <", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameLessThanOrEqualTo(String value) {
            addCriterion("pin_name <=", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameLike(String value) {
            addCriterion("pin_name like", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameNotLike(String value) {
            addCriterion("pin_name not like", value, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameIn(List<String> values) {
            addCriterion("pin_name in", values, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameNotIn(List<String> values) {
            addCriterion("pin_name not in", values, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameBetween(String value1, String value2) {
            addCriterion("pin_name between", value1, value2, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinNameNotBetween(String value1, String value2) {
            addCriterion("pin_name not between", value1, value2, "pinName");
            return (Criteria) this;
        }

        public Criteria andPinTypeIsNull() {
            addCriterion("pin_type is null");
            return (Criteria) this;
        }

        public Criteria andPinTypeIsNotNull() {
            addCriterion("pin_type is not null");
            return (Criteria) this;
        }

        public Criteria andPinTypeEqualTo(String value) {
            addCriterion("pin_type =", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeNotEqualTo(String value) {
            addCriterion("pin_type <>", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeGreaterThan(String value) {
            addCriterion("pin_type >", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pin_type >=", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeLessThan(String value) {
            addCriterion("pin_type <", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeLessThanOrEqualTo(String value) {
            addCriterion("pin_type <=", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeLike(String value) {
            addCriterion("pin_type like", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeNotLike(String value) {
            addCriterion("pin_type not like", value, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeIn(List<String> values) {
            addCriterion("pin_type in", values, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeNotIn(List<String> values) {
            addCriterion("pin_type not in", values, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeBetween(String value1, String value2) {
            addCriterion("pin_type between", value1, value2, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinTypeNotBetween(String value1, String value2) {
            addCriterion("pin_type not between", value1, value2, "pinType");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeIsNull() {
            addCriterion("pin_knowledge is null");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeIsNotNull() {
            addCriterion("pin_knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeEqualTo(String value) {
            addCriterion("pin_knowledge =", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeNotEqualTo(String value) {
            addCriterion("pin_knowledge <>", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeGreaterThan(String value) {
            addCriterion("pin_knowledge >", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("pin_knowledge >=", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeLessThan(String value) {
            addCriterion("pin_knowledge <", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeLessThanOrEqualTo(String value) {
            addCriterion("pin_knowledge <=", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeLike(String value) {
            addCriterion("pin_knowledge like", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeNotLike(String value) {
            addCriterion("pin_knowledge not like", value, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeIn(List<String> values) {
            addCriterion("pin_knowledge in", values, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeNotIn(List<String> values) {
            addCriterion("pin_knowledge not in", values, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeBetween(String value1, String value2) {
            addCriterion("pin_knowledge between", value1, value2, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinKnowledgeNotBetween(String value1, String value2) {
            addCriterion("pin_knowledge not between", value1, value2, "pinKnowledge");
            return (Criteria) this;
        }

        public Criteria andPinAnswerIsNull() {
            addCriterion("pin_answer is null");
            return (Criteria) this;
        }

        public Criteria andPinAnswerIsNotNull() {
            addCriterion("pin_answer is not null");
            return (Criteria) this;
        }

        public Criteria andPinAnswerEqualTo(String value) {
            addCriterion("pin_answer =", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerNotEqualTo(String value) {
            addCriterion("pin_answer <>", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerGreaterThan(String value) {
            addCriterion("pin_answer >", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("pin_answer >=", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerLessThan(String value) {
            addCriterion("pin_answer <", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerLessThanOrEqualTo(String value) {
            addCriterion("pin_answer <=", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerLike(String value) {
            addCriterion("pin_answer like", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerNotLike(String value) {
            addCriterion("pin_answer not like", value, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerIn(List<String> values) {
            addCriterion("pin_answer in", values, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerNotIn(List<String> values) {
            addCriterion("pin_answer not in", values, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerBetween(String value1, String value2) {
            addCriterion("pin_answer between", value1, value2, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnswerNotBetween(String value1, String value2) {
            addCriterion("pin_answer not between", value1, value2, "pinAnswer");
            return (Criteria) this;
        }

        public Criteria andPinAnlyIsNull() {
            addCriterion("pin_anly is null");
            return (Criteria) this;
        }

        public Criteria andPinAnlyIsNotNull() {
            addCriterion("pin_anly is not null");
            return (Criteria) this;
        }

        public Criteria andPinAnlyEqualTo(String value) {
            addCriterion("pin_anly =", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyNotEqualTo(String value) {
            addCriterion("pin_anly <>", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyGreaterThan(String value) {
            addCriterion("pin_anly >", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyGreaterThanOrEqualTo(String value) {
            addCriterion("pin_anly >=", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyLessThan(String value) {
            addCriterion("pin_anly <", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyLessThanOrEqualTo(String value) {
            addCriterion("pin_anly <=", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyLike(String value) {
            addCriterion("pin_anly like", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyNotLike(String value) {
            addCriterion("pin_anly not like", value, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyIn(List<String> values) {
            addCriterion("pin_anly in", values, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyNotIn(List<String> values) {
            addCriterion("pin_anly not in", values, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyBetween(String value1, String value2) {
            addCriterion("pin_anly between", value1, value2, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinAnlyNotBetween(String value1, String value2) {
            addCriterion("pin_anly not between", value1, value2, "pinAnly");
            return (Criteria) this;
        }

        public Criteria andPinScoreIsNull() {
            addCriterion("pin_score is null");
            return (Criteria) this;
        }

        public Criteria andPinScoreIsNotNull() {
            addCriterion("pin_score is not null");
            return (Criteria) this;
        }

        public Criteria andPinScoreEqualTo(Double value) {
            addCriterion("pin_score =", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreNotEqualTo(Double value) {
            addCriterion("pin_score <>", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreGreaterThan(Double value) {
            addCriterion("pin_score >", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("pin_score >=", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreLessThan(Double value) {
            addCriterion("pin_score <", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreLessThanOrEqualTo(Double value) {
            addCriterion("pin_score <=", value, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreIn(List<Double> values) {
            addCriterion("pin_score in", values, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreNotIn(List<Double> values) {
            addCriterion("pin_score not in", values, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreBetween(Double value1, Double value2) {
            addCriterion("pin_score between", value1, value2, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinScoreNotBetween(Double value1, Double value2) {
            addCriterion("pin_score not between", value1, value2, "pinScore");
            return (Criteria) this;
        }

        public Criteria andPinDifficultIsNull() {
            addCriterion("pin_difficult is null");
            return (Criteria) this;
        }

        public Criteria andPinDifficultIsNotNull() {
            addCriterion("pin_difficult is not null");
            return (Criteria) this;
        }

        public Criteria andPinDifficultEqualTo(Long value) {
            addCriterion("pin_difficult =", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultNotEqualTo(Long value) {
            addCriterion("pin_difficult <>", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultGreaterThan(Long value) {
            addCriterion("pin_difficult >", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultGreaterThanOrEqualTo(Long value) {
            addCriterion("pin_difficult >=", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultLessThan(Long value) {
            addCriterion("pin_difficult <", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultLessThanOrEqualTo(Long value) {
            addCriterion("pin_difficult <=", value, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultIn(List<Long> values) {
            addCriterion("pin_difficult in", values, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultNotIn(List<Long> values) {
            addCriterion("pin_difficult not in", values, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultBetween(Long value1, Long value2) {
            addCriterion("pin_difficult between", value1, value2, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinDifficultNotBetween(Long value1, Long value2) {
            addCriterion("pin_difficult not between", value1, value2, "pinDifficult");
            return (Criteria) this;
        }

        public Criteria andPinOptionIsNull() {
            addCriterion("pin_option is null");
            return (Criteria) this;
        }

        public Criteria andPinOptionIsNotNull() {
            addCriterion("pin_option is not null");
            return (Criteria) this;
        }

        public Criteria andPinOptionEqualTo(Integer value) {
            addCriterion("pin_option =", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionNotEqualTo(Integer value) {
            addCriterion("pin_option <>", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionGreaterThan(Integer value) {
            addCriterion("pin_option >", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("pin_option >=", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionLessThan(Integer value) {
            addCriterion("pin_option <", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionLessThanOrEqualTo(Integer value) {
            addCriterion("pin_option <=", value, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionIn(List<Integer> values) {
            addCriterion("pin_option in", values, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionNotIn(List<Integer> values) {
            addCriterion("pin_option not in", values, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionBetween(Integer value1, Integer value2) {
            addCriterion("pin_option between", value1, value2, "pinOption");
            return (Criteria) this;
        }

        public Criteria andPinOptionNotBetween(Integer value1, Integer value2) {
            addCriterion("pin_option not between", value1, value2, "pinOption");
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