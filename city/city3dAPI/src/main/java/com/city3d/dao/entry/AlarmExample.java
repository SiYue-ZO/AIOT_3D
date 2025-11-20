package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class AlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmExample() {
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

        public Criteria andAlarmIdIsNull() {
            addCriterion("alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNotNull() {
            addCriterion("alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdEqualTo(String value) {
            addCriterion("alarm_id =", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotEqualTo(String value) {
            addCriterion("alarm_id <>", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThan(String value) {
            addCriterion("alarm_id >", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_id >=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThan(String value) {
            addCriterion("alarm_id <", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThanOrEqualTo(String value) {
            addCriterion("alarm_id <=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLike(String value) {
            addCriterion("alarm_id like", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotLike(String value) {
            addCriterion("alarm_id not like", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIn(List<String> values) {
            addCriterion("alarm_id in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotIn(List<String> values) {
            addCriterion("alarm_id not in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdBetween(String value1, String value2) {
            addCriterion("alarm_id between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotBetween(String value1, String value2) {
            addCriterion("alarm_id not between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andWallIdIsNull() {
            addCriterion("wall_id is null");
            return (Criteria) this;
        }

        public Criteria andWallIdIsNotNull() {
            addCriterion("wall_id is not null");
            return (Criteria) this;
        }

        public Criteria andWallIdEqualTo(String value) {
            addCriterion("wall_id =", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotEqualTo(String value) {
            addCriterion("wall_id <>", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdGreaterThan(String value) {
            addCriterion("wall_id >", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdGreaterThanOrEqualTo(String value) {
            addCriterion("wall_id >=", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLessThan(String value) {
            addCriterion("wall_id <", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLessThanOrEqualTo(String value) {
            addCriterion("wall_id <=", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLike(String value) {
            addCriterion("wall_id like", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotLike(String value) {
            addCriterion("wall_id not like", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdIn(List<String> values) {
            addCriterion("wall_id in", values, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotIn(List<String> values) {
            addCriterion("wall_id not in", values, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdBetween(String value1, String value2) {
            addCriterion("wall_id between", value1, value2, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotBetween(String value1, String value2) {
            addCriterion("wall_id not between", value1, value2, "wallId");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("alarm_type is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("alarm_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(String value) {
            addCriterion("alarm_type =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(String value) {
            addCriterion("alarm_type <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(String value) {
            addCriterion("alarm_type >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_type >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(String value) {
            addCriterion("alarm_type <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(String value) {
            addCriterion("alarm_type <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLike(String value) {
            addCriterion("alarm_type like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotLike(String value) {
            addCriterion("alarm_type not like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<String> values) {
            addCriterion("alarm_type in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<String> values) {
            addCriterion("alarm_type not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(String value1, String value2) {
            addCriterion("alarm_type between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(String value1, String value2) {
            addCriterion("alarm_type not between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNull() {
            addCriterion("alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNotNull() {
            addCriterion("alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeEqualTo(String value) {
            addCriterion("alarm_time =", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotEqualTo(String value) {
            addCriterion("alarm_time <>", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThan(String value) {
            addCriterion("alarm_time >", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_time >=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThan(String value) {
            addCriterion("alarm_time <", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThanOrEqualTo(String value) {
            addCriterion("alarm_time <=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLike(String value) {
            addCriterion("alarm_time like", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotLike(String value) {
            addCriterion("alarm_time not like", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIn(List<String> values) {
            addCriterion("alarm_time in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotIn(List<String> values) {
            addCriterion("alarm_time not in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeBetween(String value1, String value2) {
            addCriterion("alarm_time between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotBetween(String value1, String value2) {
            addCriterion("alarm_time not between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdIsNull() {
            addCriterion("alarm_people_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdIsNotNull() {
            addCriterion("alarm_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdEqualTo(String value) {
            addCriterion("alarm_people_id =", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdNotEqualTo(String value) {
            addCriterion("alarm_people_id <>", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdGreaterThan(String value) {
            addCriterion("alarm_people_id >", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_people_id >=", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdLessThan(String value) {
            addCriterion("alarm_people_id <", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdLessThanOrEqualTo(String value) {
            addCriterion("alarm_people_id <=", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdLike(String value) {
            addCriterion("alarm_people_id like", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdNotLike(String value) {
            addCriterion("alarm_people_id not like", value, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdIn(List<String> values) {
            addCriterion("alarm_people_id in", values, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdNotIn(List<String> values) {
            addCriterion("alarm_people_id not in", values, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdBetween(String value1, String value2) {
            addCriterion("alarm_people_id between", value1, value2, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPeopleIdNotBetween(String value1, String value2) {
            addCriterion("alarm_people_id not between", value1, value2, "alarmPeopleId");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiIsNull() {
            addCriterion("alarm_poi is null");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiIsNotNull() {
            addCriterion("alarm_poi is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiEqualTo(String value) {
            addCriterion("alarm_poi =", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiNotEqualTo(String value) {
            addCriterion("alarm_poi <>", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiGreaterThan(String value) {
            addCriterion("alarm_poi >", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_poi >=", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiLessThan(String value) {
            addCriterion("alarm_poi <", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiLessThanOrEqualTo(String value) {
            addCriterion("alarm_poi <=", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiLike(String value) {
            addCriterion("alarm_poi like", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiNotLike(String value) {
            addCriterion("alarm_poi not like", value, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiIn(List<String> values) {
            addCriterion("alarm_poi in", values, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiNotIn(List<String> values) {
            addCriterion("alarm_poi not in", values, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiBetween(String value1, String value2) {
            addCriterion("alarm_poi between", value1, value2, "alarmPoi");
            return (Criteria) this;
        }

        public Criteria andAlarmPoiNotBetween(String value1, String value2) {
            addCriterion("alarm_poi not between", value1, value2, "alarmPoi");
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