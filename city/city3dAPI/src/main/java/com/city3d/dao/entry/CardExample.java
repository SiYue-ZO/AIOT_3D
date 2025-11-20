package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
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

        public Criteria andCrIdIsNull() {
            addCriterion("cr_id is null");
            return (Criteria) this;
        }

        public Criteria andCrIdIsNotNull() {
            addCriterion("cr_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrIdEqualTo(String value) {
            addCriterion("cr_id =", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotEqualTo(String value) {
            addCriterion("cr_id <>", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdGreaterThan(String value) {
            addCriterion("cr_id >", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdGreaterThanOrEqualTo(String value) {
            addCriterion("cr_id >=", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLessThan(String value) {
            addCriterion("cr_id <", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLessThanOrEqualTo(String value) {
            addCriterion("cr_id <=", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdLike(String value) {
            addCriterion("cr_id like", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotLike(String value) {
            addCriterion("cr_id not like", value, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdIn(List<String> values) {
            addCriterion("cr_id in", values, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotIn(List<String> values) {
            addCriterion("cr_id not in", values, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdBetween(String value1, String value2) {
            addCriterion("cr_id between", value1, value2, "crId");
            return (Criteria) this;
        }

        public Criteria andCrIdNotBetween(String value1, String value2) {
            addCriterion("cr_id not between", value1, value2, "crId");
            return (Criteria) this;
        }

        public Criteria andCrAddIsNull() {
            addCriterion("cr_add is null");
            return (Criteria) this;
        }

        public Criteria andCrAddIsNotNull() {
            addCriterion("cr_add is not null");
            return (Criteria) this;
        }

        public Criteria andCrAddEqualTo(String value) {
            addCriterion("cr_add =", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddNotEqualTo(String value) {
            addCriterion("cr_add <>", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddGreaterThan(String value) {
            addCriterion("cr_add >", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddGreaterThanOrEqualTo(String value) {
            addCriterion("cr_add >=", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddLessThan(String value) {
            addCriterion("cr_add <", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddLessThanOrEqualTo(String value) {
            addCriterion("cr_add <=", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddLike(String value) {
            addCriterion("cr_add like", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddNotLike(String value) {
            addCriterion("cr_add not like", value, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddIn(List<String> values) {
            addCriterion("cr_add in", values, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddNotIn(List<String> values) {
            addCriterion("cr_add not in", values, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddBetween(String value1, String value2) {
            addCriterion("cr_add between", value1, value2, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrAddNotBetween(String value1, String value2) {
            addCriterion("cr_add not between", value1, value2, "crAdd");
            return (Criteria) this;
        }

        public Criteria andCrTimeIsNull() {
            addCriterion("cr_time is null");
            return (Criteria) this;
        }

        public Criteria andCrTimeIsNotNull() {
            addCriterion("cr_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrTimeEqualTo(String value) {
            addCriterion("cr_time =", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeNotEqualTo(String value) {
            addCriterion("cr_time <>", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeGreaterThan(String value) {
            addCriterion("cr_time >", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cr_time >=", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeLessThan(String value) {
            addCriterion("cr_time <", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeLessThanOrEqualTo(String value) {
            addCriterion("cr_time <=", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeLike(String value) {
            addCriterion("cr_time like", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeNotLike(String value) {
            addCriterion("cr_time not like", value, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeIn(List<String> values) {
            addCriterion("cr_time in", values, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeNotIn(List<String> values) {
            addCriterion("cr_time not in", values, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeBetween(String value1, String value2) {
            addCriterion("cr_time between", value1, value2, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrTimeNotBetween(String value1, String value2) {
            addCriterion("cr_time not between", value1, value2, "crTime");
            return (Criteria) this;
        }

        public Criteria andCrCardnumIsNull() {
            addCriterion("cr_cardnum is null");
            return (Criteria) this;
        }

        public Criteria andCrCardnumIsNotNull() {
            addCriterion("cr_cardnum is not null");
            return (Criteria) this;
        }

        public Criteria andCrCardnumEqualTo(String value) {
            addCriterion("cr_cardnum =", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumNotEqualTo(String value) {
            addCriterion("cr_cardnum <>", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumGreaterThan(String value) {
            addCriterion("cr_cardnum >", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("cr_cardnum >=", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumLessThan(String value) {
            addCriterion("cr_cardnum <", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumLessThanOrEqualTo(String value) {
            addCriterion("cr_cardnum <=", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumLike(String value) {
            addCriterion("cr_cardnum like", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumNotLike(String value) {
            addCriterion("cr_cardnum not like", value, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumIn(List<String> values) {
            addCriterion("cr_cardnum in", values, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumNotIn(List<String> values) {
            addCriterion("cr_cardnum not in", values, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumBetween(String value1, String value2) {
            addCriterion("cr_cardnum between", value1, value2, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andCrCardnumNotBetween(String value1, String value2) {
            addCriterion("cr_cardnum not between", value1, value2, "crCardnum");
            return (Criteria) this;
        }

        public Criteria andPoiIsNull() {
            addCriterion("poi is null");
            return (Criteria) this;
        }

        public Criteria andPoiIsNotNull() {
            addCriterion("poi is not null");
            return (Criteria) this;
        }

        public Criteria andPoiEqualTo(String value) {
            addCriterion("poi =", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotEqualTo(String value) {
            addCriterion("poi <>", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThan(String value) {
            addCriterion("poi >", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThanOrEqualTo(String value) {
            addCriterion("poi >=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThan(String value) {
            addCriterion("poi <", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThanOrEqualTo(String value) {
            addCriterion("poi <=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLike(String value) {
            addCriterion("poi like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotLike(String value) {
            addCriterion("poi not like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiIn(List<String> values) {
            addCriterion("poi in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotIn(List<String> values) {
            addCriterion("poi not in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiBetween(String value1, String value2) {
            addCriterion("poi between", value1, value2, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotBetween(String value1, String value2) {
            addCriterion("poi not between", value1, value2, "poi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNull() {
            addCriterion("cam_poi is null");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNotNull() {
            addCriterion("cam_poi is not null");
            return (Criteria) this;
        }

        public Criteria andCamPoiEqualTo(String value) {
            addCriterion("cam_poi =", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotEqualTo(String value) {
            addCriterion("cam_poi <>", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThan(String value) {
            addCriterion("cam_poi >", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThanOrEqualTo(String value) {
            addCriterion("cam_poi >=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThan(String value) {
            addCriterion("cam_poi <", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThanOrEqualTo(String value) {
            addCriterion("cam_poi <=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLike(String value) {
            addCriterion("cam_poi like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotLike(String value) {
            addCriterion("cam_poi not like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIn(List<String> values) {
            addCriterion("cam_poi in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotIn(List<String> values) {
            addCriterion("cam_poi not in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiBetween(String value1, String value2) {
            addCriterion("cam_poi between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotBetween(String value1, String value2) {
            addCriterion("cam_poi not between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNull() {
            addCriterion("cam_heading is null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNotNull() {
            addCriterion("cam_heading is not null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingEqualTo(String value) {
            addCriterion("cam_heading =", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotEqualTo(String value) {
            addCriterion("cam_heading <>", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThan(String value) {
            addCriterion("cam_heading >", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("cam_heading >=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThan(String value) {
            addCriterion("cam_heading <", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThanOrEqualTo(String value) {
            addCriterion("cam_heading <=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLike(String value) {
            addCriterion("cam_heading like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotLike(String value) {
            addCriterion("cam_heading not like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIn(List<String> values) {
            addCriterion("cam_heading in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotIn(List<String> values) {
            addCriterion("cam_heading not in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingBetween(String value1, String value2) {
            addCriterion("cam_heading between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotBetween(String value1, String value2) {
            addCriterion("cam_heading not between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNull() {
            addCriterion("cam_pitch is null");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNotNull() {
            addCriterion("cam_pitch is not null");
            return (Criteria) this;
        }

        public Criteria andCamPitchEqualTo(String value) {
            addCriterion("cam_pitch =", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotEqualTo(String value) {
            addCriterion("cam_pitch <>", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThan(String value) {
            addCriterion("cam_pitch >", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pitch >=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThan(String value) {
            addCriterion("cam_pitch <", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThanOrEqualTo(String value) {
            addCriterion("cam_pitch <=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLike(String value) {
            addCriterion("cam_pitch like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotLike(String value) {
            addCriterion("cam_pitch not like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchIn(List<String> values) {
            addCriterion("cam_pitch in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotIn(List<String> values) {
            addCriterion("cam_pitch not in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchBetween(String value1, String value2) {
            addCriterion("cam_pitch between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotBetween(String value1, String value2) {
            addCriterion("cam_pitch not between", value1, value2, "camPitch");
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