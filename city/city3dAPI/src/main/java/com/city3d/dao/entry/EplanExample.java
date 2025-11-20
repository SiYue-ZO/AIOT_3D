package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class EplanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EplanExample() {
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

        public Criteria andEplanIdIsNull() {
            addCriterion("eplan_id is null");
            return (Criteria) this;
        }

        public Criteria andEplanIdIsNotNull() {
            addCriterion("eplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andEplanIdEqualTo(String value) {
            addCriterion("eplan_id =", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdNotEqualTo(String value) {
            addCriterion("eplan_id <>", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdGreaterThan(String value) {
            addCriterion("eplan_id >", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdGreaterThanOrEqualTo(String value) {
            addCriterion("eplan_id >=", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdLessThan(String value) {
            addCriterion("eplan_id <", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdLessThanOrEqualTo(String value) {
            addCriterion("eplan_id <=", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdLike(String value) {
            addCriterion("eplan_id like", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdNotLike(String value) {
            addCriterion("eplan_id not like", value, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdIn(List<String> values) {
            addCriterion("eplan_id in", values, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdNotIn(List<String> values) {
            addCriterion("eplan_id not in", values, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdBetween(String value1, String value2) {
            addCriterion("eplan_id between", value1, value2, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanIdNotBetween(String value1, String value2) {
            addCriterion("eplan_id not between", value1, value2, "eplanId");
            return (Criteria) this;
        }

        public Criteria andEplanNameIsNull() {
            addCriterion("eplan_name is null");
            return (Criteria) this;
        }

        public Criteria andEplanNameIsNotNull() {
            addCriterion("eplan_name is not null");
            return (Criteria) this;
        }

        public Criteria andEplanNameEqualTo(String value) {
            addCriterion("eplan_name =", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameNotEqualTo(String value) {
            addCriterion("eplan_name <>", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameGreaterThan(String value) {
            addCriterion("eplan_name >", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameGreaterThanOrEqualTo(String value) {
            addCriterion("eplan_name >=", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameLessThan(String value) {
            addCriterion("eplan_name <", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameLessThanOrEqualTo(String value) {
            addCriterion("eplan_name <=", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameLike(String value) {
            addCriterion("eplan_name like", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameNotLike(String value) {
            addCriterion("eplan_name not like", value, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameIn(List<String> values) {
            addCriterion("eplan_name in", values, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameNotIn(List<String> values) {
            addCriterion("eplan_name not in", values, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameBetween(String value1, String value2) {
            addCriterion("eplan_name between", value1, value2, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanNameNotBetween(String value1, String value2) {
            addCriterion("eplan_name not between", value1, value2, "eplanName");
            return (Criteria) this;
        }

        public Criteria andEplanConIsNull() {
            addCriterion("eplan_con is null");
            return (Criteria) this;
        }

        public Criteria andEplanConIsNotNull() {
            addCriterion("eplan_con is not null");
            return (Criteria) this;
        }

        public Criteria andEplanConEqualTo(String value) {
            addCriterion("eplan_con =", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConNotEqualTo(String value) {
            addCriterion("eplan_con <>", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConGreaterThan(String value) {
            addCriterion("eplan_con >", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConGreaterThanOrEqualTo(String value) {
            addCriterion("eplan_con >=", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConLessThan(String value) {
            addCriterion("eplan_con <", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConLessThanOrEqualTo(String value) {
            addCriterion("eplan_con <=", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConLike(String value) {
            addCriterion("eplan_con like", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConNotLike(String value) {
            addCriterion("eplan_con not like", value, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConIn(List<String> values) {
            addCriterion("eplan_con in", values, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConNotIn(List<String> values) {
            addCriterion("eplan_con not in", values, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConBetween(String value1, String value2) {
            addCriterion("eplan_con between", value1, value2, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanConNotBetween(String value1, String value2) {
            addCriterion("eplan_con not between", value1, value2, "eplanCon");
            return (Criteria) this;
        }

        public Criteria andEplanTypeIsNull() {
            addCriterion("eplan_type is null");
            return (Criteria) this;
        }

        public Criteria andEplanTypeIsNotNull() {
            addCriterion("eplan_type is not null");
            return (Criteria) this;
        }

        public Criteria andEplanTypeEqualTo(String value) {
            addCriterion("eplan_type =", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeNotEqualTo(String value) {
            addCriterion("eplan_type <>", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeGreaterThan(String value) {
            addCriterion("eplan_type >", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("eplan_type >=", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeLessThan(String value) {
            addCriterion("eplan_type <", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeLessThanOrEqualTo(String value) {
            addCriterion("eplan_type <=", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeLike(String value) {
            addCriterion("eplan_type like", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeNotLike(String value) {
            addCriterion("eplan_type not like", value, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeIn(List<String> values) {
            addCriterion("eplan_type in", values, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeNotIn(List<String> values) {
            addCriterion("eplan_type not in", values, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeBetween(String value1, String value2) {
            addCriterion("eplan_type between", value1, value2, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanTypeNotBetween(String value1, String value2) {
            addCriterion("eplan_type not between", value1, value2, "eplanType");
            return (Criteria) this;
        }

        public Criteria andEplanDateIsNull() {
            addCriterion("eplan_date is null");
            return (Criteria) this;
        }

        public Criteria andEplanDateIsNotNull() {
            addCriterion("eplan_date is not null");
            return (Criteria) this;
        }

        public Criteria andEplanDateEqualTo(String value) {
            addCriterion("eplan_date =", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateNotEqualTo(String value) {
            addCriterion("eplan_date <>", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateGreaterThan(String value) {
            addCriterion("eplan_date >", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateGreaterThanOrEqualTo(String value) {
            addCriterion("eplan_date >=", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateLessThan(String value) {
            addCriterion("eplan_date <", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateLessThanOrEqualTo(String value) {
            addCriterion("eplan_date <=", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateLike(String value) {
            addCriterion("eplan_date like", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateNotLike(String value) {
            addCriterion("eplan_date not like", value, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateIn(List<String> values) {
            addCriterion("eplan_date in", values, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateNotIn(List<String> values) {
            addCriterion("eplan_date not in", values, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateBetween(String value1, String value2) {
            addCriterion("eplan_date between", value1, value2, "eplanDate");
            return (Criteria) this;
        }

        public Criteria andEplanDateNotBetween(String value1, String value2) {
            addCriterion("eplan_date not between", value1, value2, "eplanDate");
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