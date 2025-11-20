package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class DutyVideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyVideoExample() {
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

        public Criteria andDutyVideoIdIsNull() {
            addCriterion("duty_video_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdIsNotNull() {
            addCriterion("duty_video_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdEqualTo(String value) {
            addCriterion("duty_video_id =", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdNotEqualTo(String value) {
            addCriterion("duty_video_id <>", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdGreaterThan(String value) {
            addCriterion("duty_video_id >", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_video_id >=", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdLessThan(String value) {
            addCriterion("duty_video_id <", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdLessThanOrEqualTo(String value) {
            addCriterion("duty_video_id <=", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdLike(String value) {
            addCriterion("duty_video_id like", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdNotLike(String value) {
            addCriterion("duty_video_id not like", value, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdIn(List<String> values) {
            addCriterion("duty_video_id in", values, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdNotIn(List<String> values) {
            addCriterion("duty_video_id not in", values, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdBetween(String value1, String value2) {
            addCriterion("duty_video_id between", value1, value2, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyVideoIdNotBetween(String value1, String value2) {
            addCriterion("duty_video_id not between", value1, value2, "dutyVideoId");
            return (Criteria) this;
        }

        public Criteria andDutyNameIsNull() {
            addCriterion("duty_name is null");
            return (Criteria) this;
        }

        public Criteria andDutyNameIsNotNull() {
            addCriterion("duty_name is not null");
            return (Criteria) this;
        }

        public Criteria andDutyNameEqualTo(String value) {
            addCriterion("duty_name =", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotEqualTo(String value) {
            addCriterion("duty_name <>", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameGreaterThan(String value) {
            addCriterion("duty_name >", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameGreaterThanOrEqualTo(String value) {
            addCriterion("duty_name >=", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLessThan(String value) {
            addCriterion("duty_name <", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLessThanOrEqualTo(String value) {
            addCriterion("duty_name <=", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLike(String value) {
            addCriterion("duty_name like", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotLike(String value) {
            addCriterion("duty_name not like", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameIn(List<String> values) {
            addCriterion("duty_name in", values, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotIn(List<String> values) {
            addCriterion("duty_name not in", values, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameBetween(String value1, String value2) {
            addCriterion("duty_name between", value1, value2, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotBetween(String value1, String value2) {
            addCriterion("duty_name not between", value1, value2, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyTimeIsNull() {
            addCriterion("duty_time is null");
            return (Criteria) this;
        }

        public Criteria andDutyTimeIsNotNull() {
            addCriterion("duty_time is not null");
            return (Criteria) this;
        }

        public Criteria andDutyTimeEqualTo(String value) {
            addCriterion("duty_time =", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeNotEqualTo(String value) {
            addCriterion("duty_time <>", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeGreaterThan(String value) {
            addCriterion("duty_time >", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("duty_time >=", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeLessThan(String value) {
            addCriterion("duty_time <", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeLessThanOrEqualTo(String value) {
            addCriterion("duty_time <=", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeLike(String value) {
            addCriterion("duty_time like", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeNotLike(String value) {
            addCriterion("duty_time not like", value, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeIn(List<String> values) {
            addCriterion("duty_time in", values, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeNotIn(List<String> values) {
            addCriterion("duty_time not in", values, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeBetween(String value1, String value2) {
            addCriterion("duty_time between", value1, value2, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTimeNotBetween(String value1, String value2) {
            addCriterion("duty_time not between", value1, value2, "dutyTime");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIsNull() {
            addCriterion("duty_type is null");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIsNotNull() {
            addCriterion("duty_type is not null");
            return (Criteria) this;
        }

        public Criteria andDutyTypeEqualTo(String value) {
            addCriterion("duty_type =", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotEqualTo(String value) {
            addCriterion("duty_type <>", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeGreaterThan(String value) {
            addCriterion("duty_type >", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("duty_type >=", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLessThan(String value) {
            addCriterion("duty_type <", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLessThanOrEqualTo(String value) {
            addCriterion("duty_type <=", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLike(String value) {
            addCriterion("duty_type like", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotLike(String value) {
            addCriterion("duty_type not like", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIn(List<String> values) {
            addCriterion("duty_type in", values, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotIn(List<String> values) {
            addCriterion("duty_type not in", values, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeBetween(String value1, String value2) {
            addCriterion("duty_type between", value1, value2, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotBetween(String value1, String value2) {
            addCriterion("duty_type not between", value1, value2, "dutyType");
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