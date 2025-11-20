package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PoliceLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoliceLineExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andLIdIsNull() {
            addCriterion("l_id is null");
            return (Criteria) this;
        }

        public Criteria andLIdIsNotNull() {
            addCriterion("l_id is not null");
            return (Criteria) this;
        }

        public Criteria andLIdEqualTo(String value) {
            addCriterion("l_id =", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotEqualTo(String value) {
            addCriterion("l_id <>", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThan(String value) {
            addCriterion("l_id >", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdGreaterThanOrEqualTo(String value) {
            addCriterion("l_id >=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThan(String value) {
            addCriterion("l_id <", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLessThanOrEqualTo(String value) {
            addCriterion("l_id <=", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdLike(String value) {
            addCriterion("l_id like", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotLike(String value) {
            addCriterion("l_id not like", value, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdIn(List<String> values) {
            addCriterion("l_id in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotIn(List<String> values) {
            addCriterion("l_id not in", values, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdBetween(String value1, String value2) {
            addCriterion("l_id between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andLIdNotBetween(String value1, String value2) {
            addCriterion("l_id not between", value1, value2, "lId");
            return (Criteria) this;
        }

        public Criteria andLNameIsNull() {
            addCriterion("l_name is null");
            return (Criteria) this;
        }

        public Criteria andLNameIsNotNull() {
            addCriterion("l_name is not null");
            return (Criteria) this;
        }

        public Criteria andLNameEqualTo(String value) {
            addCriterion("l_name =", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotEqualTo(String value) {
            addCriterion("l_name <>", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameGreaterThan(String value) {
            addCriterion("l_name >", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameGreaterThanOrEqualTo(String value) {
            addCriterion("l_name >=", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLessThan(String value) {
            addCriterion("l_name <", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLessThanOrEqualTo(String value) {
            addCriterion("l_name <=", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameLike(String value) {
            addCriterion("l_name like", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotLike(String value) {
            addCriterion("l_name not like", value, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameIn(List<String> values) {
            addCriterion("l_name in", values, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotIn(List<String> values) {
            addCriterion("l_name not in", values, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameBetween(String value1, String value2) {
            addCriterion("l_name between", value1, value2, "lName");
            return (Criteria) this;
        }

        public Criteria andLNameNotBetween(String value1, String value2) {
            addCriterion("l_name not between", value1, value2, "lName");
            return (Criteria) this;
        }

        public Criteria andLTypeIsNull() {
            addCriterion("l_type is null");
            return (Criteria) this;
        }

        public Criteria andLTypeIsNotNull() {
            addCriterion("l_type is not null");
            return (Criteria) this;
        }

        public Criteria andLTypeEqualTo(String value) {
            addCriterion("l_type =", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotEqualTo(String value) {
            addCriterion("l_type <>", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeGreaterThan(String value) {
            addCriterion("l_type >", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeGreaterThanOrEqualTo(String value) {
            addCriterion("l_type >=", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeLessThan(String value) {
            addCriterion("l_type <", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeLessThanOrEqualTo(String value) {
            addCriterion("l_type <=", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeLike(String value) {
            addCriterion("l_type like", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotLike(String value) {
            addCriterion("l_type not like", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeIn(List<String> values) {
            addCriterion("l_type in", values, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotIn(List<String> values) {
            addCriterion("l_type not in", values, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeBetween(String value1, String value2) {
            addCriterion("l_type between", value1, value2, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotBetween(String value1, String value2) {
            addCriterion("l_type not between", value1, value2, "lType");
            return (Criteria) this;
        }

        public Criteria andLPoylineIsNull() {
            addCriterion("l_poyline is null");
            return (Criteria) this;
        }

        public Criteria andLPoylineIsNotNull() {
            addCriterion("l_poyline is not null");
            return (Criteria) this;
        }

        public Criteria andLPoylineEqualTo(String value) {
            addCriterion("l_poyline =", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineNotEqualTo(String value) {
            addCriterion("l_poyline <>", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineGreaterThan(String value) {
            addCriterion("l_poyline >", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineGreaterThanOrEqualTo(String value) {
            addCriterion("l_poyline >=", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineLessThan(String value) {
            addCriterion("l_poyline <", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineLessThanOrEqualTo(String value) {
            addCriterion("l_poyline <=", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineLike(String value) {
            addCriterion("l_poyline like", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineNotLike(String value) {
            addCriterion("l_poyline not like", value, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineIn(List<String> values) {
            addCriterion("l_poyline in", values, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineNotIn(List<String> values) {
            addCriterion("l_poyline not in", values, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineBetween(String value1, String value2) {
            addCriterion("l_poyline between", value1, value2, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLPoylineNotBetween(String value1, String value2) {
            addCriterion("l_poyline not between", value1, value2, "lPoyline");
            return (Criteria) this;
        }

        public Criteria andLColorIsNull() {
            addCriterion("l_color is null");
            return (Criteria) this;
        }

        public Criteria andLColorIsNotNull() {
            addCriterion("l_color is not null");
            return (Criteria) this;
        }

        public Criteria andLColorEqualTo(String value) {
            addCriterion("l_color =", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorNotEqualTo(String value) {
            addCriterion("l_color <>", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorGreaterThan(String value) {
            addCriterion("l_color >", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorGreaterThanOrEqualTo(String value) {
            addCriterion("l_color >=", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorLessThan(String value) {
            addCriterion("l_color <", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorLessThanOrEqualTo(String value) {
            addCriterion("l_color <=", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorLike(String value) {
            addCriterion("l_color like", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorNotLike(String value) {
            addCriterion("l_color not like", value, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorIn(List<String> values) {
            addCriterion("l_color in", values, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorNotIn(List<String> values) {
            addCriterion("l_color not in", values, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorBetween(String value1, String value2) {
            addCriterion("l_color between", value1, value2, "lColor");
            return (Criteria) this;
        }

        public Criteria andLColorNotBetween(String value1, String value2) {
            addCriterion("l_color not between", value1, value2, "lColor");
            return (Criteria) this;
        }

        public Criteria andLTimeIsNull() {
            addCriterion("l_time is null");
            return (Criteria) this;
        }

        public Criteria andLTimeIsNotNull() {
            addCriterion("l_time is not null");
            return (Criteria) this;
        }

        public Criteria andLTimeEqualTo(String value) {
            addCriterion("l_time =", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotEqualTo(String value) {
            addCriterion("l_time <>", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeGreaterThan(String value) {
            addCriterion("l_time >", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeGreaterThanOrEqualTo(String value) {
            addCriterion("l_time >=", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeLessThan(String value) {
            addCriterion("l_time <", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeLessThanOrEqualTo(String value) {
            addCriterion("l_time <=", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeLike(String value) {
            addCriterion("l_time like", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotLike(String value) {
            addCriterion("l_time not like", value, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeIn(List<String> values) {
            addCriterion("l_time in", values, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotIn(List<String> values) {
            addCriterion("l_time not in", values, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeBetween(String value1, String value2) {
            addCriterion("l_time between", value1, value2, "lTime");
            return (Criteria) this;
        }

        public Criteria andLTimeNotBetween(String value1, String value2) {
            addCriterion("l_time not between", value1, value2, "lTime");
            return (Criteria) this;
        }

        public Criteria andLPNameIsNull() {
            addCriterion("l_p_name is null");
            return (Criteria) this;
        }

        public Criteria andLPNameIsNotNull() {
            addCriterion("l_p_name is not null");
            return (Criteria) this;
        }

        public Criteria andLPNameEqualTo(String value) {
            addCriterion("l_p_name =", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameNotEqualTo(String value) {
            addCriterion("l_p_name <>", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameGreaterThan(String value) {
            addCriterion("l_p_name >", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameGreaterThanOrEqualTo(String value) {
            addCriterion("l_p_name >=", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameLessThan(String value) {
            addCriterion("l_p_name <", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameLessThanOrEqualTo(String value) {
            addCriterion("l_p_name <=", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameLike(String value) {
            addCriterion("l_p_name like", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameNotLike(String value) {
            addCriterion("l_p_name not like", value, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameIn(List<String> values) {
            addCriterion("l_p_name in", values, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameNotIn(List<String> values) {
            addCriterion("l_p_name not in", values, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameBetween(String value1, String value2) {
            addCriterion("l_p_name between", value1, value2, "lPName");
            return (Criteria) this;
        }

        public Criteria andLPNameNotBetween(String value1, String value2) {
            addCriterion("l_p_name not between", value1, value2, "lPName");
            return (Criteria) this;
        }

        public Criteria andLStopIsNull() {
            addCriterion("l_stop is null");
            return (Criteria) this;
        }

        public Criteria andLStopIsNotNull() {
            addCriterion("l_stop is not null");
            return (Criteria) this;
        }

        public Criteria andLStopEqualTo(String value) {
            addCriterion("l_stop =", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopNotEqualTo(String value) {
            addCriterion("l_stop <>", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopGreaterThan(String value) {
            addCriterion("l_stop >", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopGreaterThanOrEqualTo(String value) {
            addCriterion("l_stop >=", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopLessThan(String value) {
            addCriterion("l_stop <", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopLessThanOrEqualTo(String value) {
            addCriterion("l_stop <=", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopLike(String value) {
            addCriterion("l_stop like", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopNotLike(String value) {
            addCriterion("l_stop not like", value, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopIn(List<String> values) {
            addCriterion("l_stop in", values, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopNotIn(List<String> values) {
            addCriterion("l_stop not in", values, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopBetween(String value1, String value2) {
            addCriterion("l_stop between", value1, value2, "lStop");
            return (Criteria) this;
        }

        public Criteria andLStopNotBetween(String value1, String value2) {
            addCriterion("l_stop not between", value1, value2, "lStop");
            return (Criteria) this;
        }

        public Criteria andLLivingIsNull() {
            addCriterion("l_living is null");
            return (Criteria) this;
        }

        public Criteria andLLivingIsNotNull() {
            addCriterion("l_living is not null");
            return (Criteria) this;
        }

        public Criteria andLLivingEqualTo(String value) {
            addCriterion("l_living =", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingNotEqualTo(String value) {
            addCriterion("l_living <>", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingGreaterThan(String value) {
            addCriterion("l_living >", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingGreaterThanOrEqualTo(String value) {
            addCriterion("l_living >=", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingLessThan(String value) {
            addCriterion("l_living <", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingLessThanOrEqualTo(String value) {
            addCriterion("l_living <=", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingLike(String value) {
            addCriterion("l_living like", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingNotLike(String value) {
            addCriterion("l_living not like", value, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingIn(List<String> values) {
            addCriterion("l_living in", values, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingNotIn(List<String> values) {
            addCriterion("l_living not in", values, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingBetween(String value1, String value2) {
            addCriterion("l_living between", value1, value2, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLLivingNotBetween(String value1, String value2) {
            addCriterion("l_living not between", value1, value2, "lLiving");
            return (Criteria) this;
        }

        public Criteria andLNoteIsNull() {
            addCriterion("l_note is null");
            return (Criteria) this;
        }

        public Criteria andLNoteIsNotNull() {
            addCriterion("l_note is not null");
            return (Criteria) this;
        }

        public Criteria andLNoteEqualTo(String value) {
            addCriterion("l_note =", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteNotEqualTo(String value) {
            addCriterion("l_note <>", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteGreaterThan(String value) {
            addCriterion("l_note >", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteGreaterThanOrEqualTo(String value) {
            addCriterion("l_note >=", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteLessThan(String value) {
            addCriterion("l_note <", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteLessThanOrEqualTo(String value) {
            addCriterion("l_note <=", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteLike(String value) {
            addCriterion("l_note like", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteNotLike(String value) {
            addCriterion("l_note not like", value, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteIn(List<String> values) {
            addCriterion("l_note in", values, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteNotIn(List<String> values) {
            addCriterion("l_note not in", values, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteBetween(String value1, String value2) {
            addCriterion("l_note between", value1, value2, "lNote");
            return (Criteria) this;
        }

        public Criteria andLNoteNotBetween(String value1, String value2) {
            addCriterion("l_note not between", value1, value2, "lNote");
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