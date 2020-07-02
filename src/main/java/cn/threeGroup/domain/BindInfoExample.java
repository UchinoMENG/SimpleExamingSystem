package cn.threeGroup.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
public class BindInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BindInfoExample() {
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

        public Criteria andUseremailIsNull() {
            addCriterion("useremail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("useremail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("useremail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("useremail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("useremail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("useremail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("useremail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("useremail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("useremail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("useremail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("useremail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("useremail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("useremail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("useremail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMarginIsNull() {
            addCriterion("margin is null");
            return (Criteria) this;
        }

        public Criteria andMarginIsNotNull() {
            addCriterion("margin is not null");
            return (Criteria) this;
        }

        public Criteria andMarginEqualTo(String value) {
            addCriterion("margin =", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotEqualTo(String value) {
            addCriterion("margin <>", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThan(String value) {
            addCriterion("margin >", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThanOrEqualTo(String value) {
            addCriterion("margin >=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThan(String value) {
            addCriterion("margin <", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThanOrEqualTo(String value) {
            addCriterion("margin <=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLike(String value) {
            addCriterion("margin like", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotLike(String value) {
            addCriterion("margin not like", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginIn(List<String> values) {
            addCriterion("margin in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotIn(List<String> values) {
            addCriterion("margin not in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginBetween(String value1, String value2) {
            addCriterion("margin between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotBetween(String value1, String value2) {
            addCriterion("margin not between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andUserclassIsNull() {
            addCriterion("userclass is null");
            return (Criteria) this;
        }

        public Criteria andUserclassIsNotNull() {
            addCriterion("userclass is not null");
            return (Criteria) this;
        }

        public Criteria andUserclassEqualTo(String value) {
            addCriterion("userclass =", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotEqualTo(String value) {
            addCriterion("userclass <>", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassGreaterThan(String value) {
            addCriterion("userclass >", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassGreaterThanOrEqualTo(String value) {
            addCriterion("userclass >=", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLessThan(String value) {
            addCriterion("userclass <", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLessThanOrEqualTo(String value) {
            addCriterion("userclass <=", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassLike(String value) {
            addCriterion("userclass like", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotLike(String value) {
            addCriterion("userclass not like", value, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassIn(List<String> values) {
            addCriterion("userclass in", values, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotIn(List<String> values) {
            addCriterion("userclass not in", values, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassBetween(String value1, String value2) {
            addCriterion("userclass between", value1, value2, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserclassNotBetween(String value1, String value2) {
            addCriterion("userclass not between", value1, value2, "userclass");
            return (Criteria) this;
        }

        public Criteria andUserschoolIsNull() {
            addCriterion("userschool is null");
            return (Criteria) this;
        }

        public Criteria andUserschoolIsNotNull() {
            addCriterion("userschool is not null");
            return (Criteria) this;
        }

        public Criteria andUserschoolEqualTo(String value) {
            addCriterion("userschool =", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolNotEqualTo(String value) {
            addCriterion("userschool <>", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolGreaterThan(String value) {
            addCriterion("userschool >", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolGreaterThanOrEqualTo(String value) {
            addCriterion("userschool >=", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolLessThan(String value) {
            addCriterion("userschool <", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolLessThanOrEqualTo(String value) {
            addCriterion("userschool <=", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolLike(String value) {
            addCriterion("userschool like", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolNotLike(String value) {
            addCriterion("userschool not like", value, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolIn(List<String> values) {
            addCriterion("userschool in", values, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolNotIn(List<String> values) {
            addCriterion("userschool not in", values, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolBetween(String value1, String value2) {
            addCriterion("userschool between", value1, value2, "userschool");
            return (Criteria) this;
        }

        public Criteria andUserschoolNotBetween(String value1, String value2) {
            addCriterion("userschool not between", value1, value2, "userschool");
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