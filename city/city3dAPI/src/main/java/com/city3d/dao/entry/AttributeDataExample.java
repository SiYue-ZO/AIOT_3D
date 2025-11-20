package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class AttributeDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttributeDataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNull() {
            addCriterion("attr_id is null");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNotNull() {
            addCriterion("attr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttrIdEqualTo(String value) {
            addCriterion("attr_id =", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotEqualTo(String value) {
            addCriterion("attr_id <>", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThan(String value) {
            addCriterion("attr_id >", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThanOrEqualTo(String value) {
            addCriterion("attr_id >=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThan(String value) {
            addCriterion("attr_id <", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThanOrEqualTo(String value) {
            addCriterion("attr_id <=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLike(String value) {
            addCriterion("attr_id like", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotLike(String value) {
            addCriterion("attr_id not like", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIn(List<String> values) {
            addCriterion("attr_id in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotIn(List<String> values) {
            addCriterion("attr_id not in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdBetween(String value1, String value2) {
            addCriterion("attr_id between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotBetween(String value1, String value2) {
            addCriterion("attr_id not between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdIsNull() {
            addCriterion("coverage_id is null");
            return (Criteria) this;
        }

        public Criteria andCoverageIdIsNotNull() {
            addCriterion("coverage_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoverageIdEqualTo(String value) {
            addCriterion("coverage_id =", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdNotEqualTo(String value) {
            addCriterion("coverage_id <>", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdGreaterThan(String value) {
            addCriterion("coverage_id >", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdGreaterThanOrEqualTo(String value) {
            addCriterion("coverage_id >=", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdLessThan(String value) {
            addCriterion("coverage_id <", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdLessThanOrEqualTo(String value) {
            addCriterion("coverage_id <=", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdLike(String value) {
            addCriterion("coverage_id like", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdNotLike(String value) {
            addCriterion("coverage_id not like", value, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdIn(List<String> values) {
            addCriterion("coverage_id in", values, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdNotIn(List<String> values) {
            addCriterion("coverage_id not in", values, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdBetween(String value1, String value2) {
            addCriterion("coverage_id between", value1, value2, "coverageId");
            return (Criteria) this;
        }

        public Criteria andCoverageIdNotBetween(String value1, String value2) {
            addCriterion("coverage_id not between", value1, value2, "coverageId");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNull() {
            addCriterion("add_name is null");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNotNull() {
            addCriterion("add_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddNameEqualTo(String value) {
            addCriterion("add_name =", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotEqualTo(String value) {
            addCriterion("add_name <>", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThan(String value) {
            addCriterion("add_name >", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_name >=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThan(String value) {
            addCriterion("add_name <", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThanOrEqualTo(String value) {
            addCriterion("add_name <=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLike(String value) {
            addCriterion("add_name like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotLike(String value) {
            addCriterion("add_name not like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameIn(List<String> values) {
            addCriterion("add_name in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotIn(List<String> values) {
            addCriterion("add_name not in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameBetween(String value1, String value2) {
            addCriterion("add_name between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotBetween(String value1, String value2) {
            addCriterion("add_name not between", value1, value2, "addName");
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

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
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