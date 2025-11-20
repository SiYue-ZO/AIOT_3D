package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class ManPosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManPosExample() {
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

        public Criteria andRealIdIsNull() {
            addCriterion("real_id is null");
            return (Criteria) this;
        }

        public Criteria andRealIdIsNotNull() {
            addCriterion("real_id is not null");
            return (Criteria) this;
        }

        public Criteria andRealIdEqualTo(String value) {
            addCriterion("real_id =", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotEqualTo(String value) {
            addCriterion("real_id <>", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThan(String value) {
            addCriterion("real_id >", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThanOrEqualTo(String value) {
            addCriterion("real_id >=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThan(String value) {
            addCriterion("real_id <", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThanOrEqualTo(String value) {
            addCriterion("real_id <=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLike(String value) {
            addCriterion("real_id like", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotLike(String value) {
            addCriterion("real_id not like", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdIn(List<String> values) {
            addCriterion("real_id in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotIn(List<String> values) {
            addCriterion("real_id not in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdBetween(String value1, String value2) {
            addCriterion("real_id between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotBetween(String value1, String value2) {
            addCriterion("real_id not between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andRealPosIsNull() {
            addCriterion("real_pos is null");
            return (Criteria) this;
        }

        public Criteria andRealPosIsNotNull() {
            addCriterion("real_pos is not null");
            return (Criteria) this;
        }

        public Criteria andRealPosEqualTo(String value) {
            addCriterion("real_pos =", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosNotEqualTo(String value) {
            addCriterion("real_pos <>", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosGreaterThan(String value) {
            addCriterion("real_pos >", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosGreaterThanOrEqualTo(String value) {
            addCriterion("real_pos >=", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosLessThan(String value) {
            addCriterion("real_pos <", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosLessThanOrEqualTo(String value) {
            addCriterion("real_pos <=", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosLike(String value) {
            addCriterion("real_pos like", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosNotLike(String value) {
            addCriterion("real_pos not like", value, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosIn(List<String> values) {
            addCriterion("real_pos in", values, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosNotIn(List<String> values) {
            addCriterion("real_pos not in", values, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosBetween(String value1, String value2) {
            addCriterion("real_pos between", value1, value2, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealPosNotBetween(String value1, String value2) {
            addCriterion("real_pos not between", value1, value2, "realPos");
            return (Criteria) this;
        }

        public Criteria andRealTimeIsNull() {
            addCriterion("real_time is null");
            return (Criteria) this;
        }

        public Criteria andRealTimeIsNotNull() {
            addCriterion("real_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealTimeEqualTo(String value) {
            addCriterion("real_time =", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeNotEqualTo(String value) {
            addCriterion("real_time <>", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeGreaterThan(String value) {
            addCriterion("real_time >", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("real_time >=", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeLessThan(String value) {
            addCriterion("real_time <", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeLessThanOrEqualTo(String value) {
            addCriterion("real_time <=", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeLike(String value) {
            addCriterion("real_time like", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeNotLike(String value) {
            addCriterion("real_time not like", value, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeIn(List<String> values) {
            addCriterion("real_time in", values, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeNotIn(List<String> values) {
            addCriterion("real_time not in", values, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeBetween(String value1, String value2) {
            addCriterion("real_time between", value1, value2, "realTime");
            return (Criteria) this;
        }

        public Criteria andRealTimeNotBetween(String value1, String value2) {
            addCriterion("real_time not between", value1, value2, "realTime");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNull() {
            addCriterion("device_num is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNotNull() {
            addCriterion("device_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumEqualTo(String value) {
            addCriterion("device_num =", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotEqualTo(String value) {
            addCriterion("device_num <>", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThan(String value) {
            addCriterion("device_num >", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThanOrEqualTo(String value) {
            addCriterion("device_num >=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThan(String value) {
            addCriterion("device_num <", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThanOrEqualTo(String value) {
            addCriterion("device_num <=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLike(String value) {
            addCriterion("device_num like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotLike(String value) {
            addCriterion("device_num not like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIn(List<String> values) {
            addCriterion("device_num in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotIn(List<String> values) {
            addCriterion("device_num not in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumBetween(String value1, String value2) {
            addCriterion("device_num between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotBetween(String value1, String value2) {
            addCriterion("device_num not between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andRealTypeIsNull() {
            addCriterion("real_type is null");
            return (Criteria) this;
        }

        public Criteria andRealTypeIsNotNull() {
            addCriterion("real_type is not null");
            return (Criteria) this;
        }

        public Criteria andRealTypeEqualTo(String value) {
            addCriterion("real_type =", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeNotEqualTo(String value) {
            addCriterion("real_type <>", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeGreaterThan(String value) {
            addCriterion("real_type >", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeGreaterThanOrEqualTo(String value) {
            addCriterion("real_type >=", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeLessThan(String value) {
            addCriterion("real_type <", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeLessThanOrEqualTo(String value) {
            addCriterion("real_type <=", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeLike(String value) {
            addCriterion("real_type like", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeNotLike(String value) {
            addCriterion("real_type not like", value, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeIn(List<String> values) {
            addCriterion("real_type in", values, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeNotIn(List<String> values) {
            addCriterion("real_type not in", values, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeBetween(String value1, String value2) {
            addCriterion("real_type between", value1, value2, "realType");
            return (Criteria) this;
        }

        public Criteria andRealTypeNotBetween(String value1, String value2) {
            addCriterion("real_type not between", value1, value2, "realType");
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