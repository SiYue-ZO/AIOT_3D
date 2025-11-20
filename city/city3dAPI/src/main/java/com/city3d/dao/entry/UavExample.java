package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class UavExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UavExample() {
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

        public Criteria andUavIdIsNull() {
            addCriterion("uav_id is null");
            return (Criteria) this;
        }

        public Criteria andUavIdIsNotNull() {
            addCriterion("uav_id is not null");
            return (Criteria) this;
        }

        public Criteria andUavIdEqualTo(String value) {
            addCriterion("uav_id =", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotEqualTo(String value) {
            addCriterion("uav_id <>", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdGreaterThan(String value) {
            addCriterion("uav_id >", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdGreaterThanOrEqualTo(String value) {
            addCriterion("uav_id >=", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLessThan(String value) {
            addCriterion("uav_id <", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLessThanOrEqualTo(String value) {
            addCriterion("uav_id <=", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLike(String value) {
            addCriterion("uav_id like", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotLike(String value) {
            addCriterion("uav_id not like", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdIn(List<String> values) {
            addCriterion("uav_id in", values, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotIn(List<String> values) {
            addCriterion("uav_id not in", values, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdBetween(String value1, String value2) {
            addCriterion("uav_id between", value1, value2, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotBetween(String value1, String value2) {
            addCriterion("uav_id not between", value1, value2, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavNameIsNull() {
            addCriterion("uav_name is null");
            return (Criteria) this;
        }

        public Criteria andUavNameIsNotNull() {
            addCriterion("uav_name is not null");
            return (Criteria) this;
        }

        public Criteria andUavNameEqualTo(String value) {
            addCriterion("uav_name =", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameNotEqualTo(String value) {
            addCriterion("uav_name <>", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameGreaterThan(String value) {
            addCriterion("uav_name >", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameGreaterThanOrEqualTo(String value) {
            addCriterion("uav_name >=", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameLessThan(String value) {
            addCriterion("uav_name <", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameLessThanOrEqualTo(String value) {
            addCriterion("uav_name <=", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameLike(String value) {
            addCriterion("uav_name like", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameNotLike(String value) {
            addCriterion("uav_name not like", value, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameIn(List<String> values) {
            addCriterion("uav_name in", values, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameNotIn(List<String> values) {
            addCriterion("uav_name not in", values, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameBetween(String value1, String value2) {
            addCriterion("uav_name between", value1, value2, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavNameNotBetween(String value1, String value2) {
            addCriterion("uav_name not between", value1, value2, "uavName");
            return (Criteria) this;
        }

        public Criteria andUavTypeIsNull() {
            addCriterion("uav_type is null");
            return (Criteria) this;
        }

        public Criteria andUavTypeIsNotNull() {
            addCriterion("uav_type is not null");
            return (Criteria) this;
        }

        public Criteria andUavTypeEqualTo(String value) {
            addCriterion("uav_type =", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeNotEqualTo(String value) {
            addCriterion("uav_type <>", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeGreaterThan(String value) {
            addCriterion("uav_type >", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeGreaterThanOrEqualTo(String value) {
            addCriterion("uav_type >=", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeLessThan(String value) {
            addCriterion("uav_type <", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeLessThanOrEqualTo(String value) {
            addCriterion("uav_type <=", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeLike(String value) {
            addCriterion("uav_type like", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeNotLike(String value) {
            addCriterion("uav_type not like", value, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeIn(List<String> values) {
            addCriterion("uav_type in", values, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeNotIn(List<String> values) {
            addCriterion("uav_type not in", values, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeBetween(String value1, String value2) {
            addCriterion("uav_type between", value1, value2, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavTypeNotBetween(String value1, String value2) {
            addCriterion("uav_type not between", value1, value2, "uavType");
            return (Criteria) this;
        }

        public Criteria andUavModelIsNull() {
            addCriterion("uav_model is null");
            return (Criteria) this;
        }

        public Criteria andUavModelIsNotNull() {
            addCriterion("uav_model is not null");
            return (Criteria) this;
        }

        public Criteria andUavModelEqualTo(String value) {
            addCriterion("uav_model =", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelNotEqualTo(String value) {
            addCriterion("uav_model <>", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelGreaterThan(String value) {
            addCriterion("uav_model >", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelGreaterThanOrEqualTo(String value) {
            addCriterion("uav_model >=", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelLessThan(String value) {
            addCriterion("uav_model <", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelLessThanOrEqualTo(String value) {
            addCriterion("uav_model <=", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelLike(String value) {
            addCriterion("uav_model like", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelNotLike(String value) {
            addCriterion("uav_model not like", value, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelIn(List<String> values) {
            addCriterion("uav_model in", values, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelNotIn(List<String> values) {
            addCriterion("uav_model not in", values, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelBetween(String value1, String value2) {
            addCriterion("uav_model between", value1, value2, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavModelNotBetween(String value1, String value2) {
            addCriterion("uav_model not between", value1, value2, "uavModel");
            return (Criteria) this;
        }

        public Criteria andUavPropertyIsNull() {
            addCriterion("uav_property is null");
            return (Criteria) this;
        }

        public Criteria andUavPropertyIsNotNull() {
            addCriterion("uav_property is not null");
            return (Criteria) this;
        }

        public Criteria andUavPropertyEqualTo(String value) {
            addCriterion("uav_property =", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyNotEqualTo(String value) {
            addCriterion("uav_property <>", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyGreaterThan(String value) {
            addCriterion("uav_property >", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("uav_property >=", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyLessThan(String value) {
            addCriterion("uav_property <", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyLessThanOrEqualTo(String value) {
            addCriterion("uav_property <=", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyLike(String value) {
            addCriterion("uav_property like", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyNotLike(String value) {
            addCriterion("uav_property not like", value, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyIn(List<String> values) {
            addCriterion("uav_property in", values, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyNotIn(List<String> values) {
            addCriterion("uav_property not in", values, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyBetween(String value1, String value2) {
            addCriterion("uav_property between", value1, value2, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavPropertyNotBetween(String value1, String value2) {
            addCriterion("uav_property not between", value1, value2, "uavProperty");
            return (Criteria) this;
        }

        public Criteria andUavDateIsNull() {
            addCriterion("uav_date is null");
            return (Criteria) this;
        }

        public Criteria andUavDateIsNotNull() {
            addCriterion("uav_date is not null");
            return (Criteria) this;
        }

        public Criteria andUavDateEqualTo(String value) {
            addCriterion("uav_date =", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateNotEqualTo(String value) {
            addCriterion("uav_date <>", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateGreaterThan(String value) {
            addCriterion("uav_date >", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateGreaterThanOrEqualTo(String value) {
            addCriterion("uav_date >=", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateLessThan(String value) {
            addCriterion("uav_date <", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateLessThanOrEqualTo(String value) {
            addCriterion("uav_date <=", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateLike(String value) {
            addCriterion("uav_date like", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateNotLike(String value) {
            addCriterion("uav_date not like", value, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateIn(List<String> values) {
            addCriterion("uav_date in", values, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateNotIn(List<String> values) {
            addCriterion("uav_date not in", values, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateBetween(String value1, String value2) {
            addCriterion("uav_date between", value1, value2, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavDateNotBetween(String value1, String value2) {
            addCriterion("uav_date not between", value1, value2, "uavDate");
            return (Criteria) this;
        }

        public Criteria andUavElecIsNull() {
            addCriterion("uav_elec is null");
            return (Criteria) this;
        }

        public Criteria andUavElecIsNotNull() {
            addCriterion("uav_elec is not null");
            return (Criteria) this;
        }

        public Criteria andUavElecEqualTo(String value) {
            addCriterion("uav_elec =", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecNotEqualTo(String value) {
            addCriterion("uav_elec <>", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecGreaterThan(String value) {
            addCriterion("uav_elec >", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecGreaterThanOrEqualTo(String value) {
            addCriterion("uav_elec >=", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecLessThan(String value) {
            addCriterion("uav_elec <", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecLessThanOrEqualTo(String value) {
            addCriterion("uav_elec <=", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecLike(String value) {
            addCriterion("uav_elec like", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecNotLike(String value) {
            addCriterion("uav_elec not like", value, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecIn(List<String> values) {
            addCriterion("uav_elec in", values, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecNotIn(List<String> values) {
            addCriterion("uav_elec not in", values, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecBetween(String value1, String value2) {
            addCriterion("uav_elec between", value1, value2, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavElecNotBetween(String value1, String value2) {
            addCriterion("uav_elec not between", value1, value2, "uavElec");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeIsNull() {
            addCriterion("uav_cam_type is null");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeIsNotNull() {
            addCriterion("uav_cam_type is not null");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeEqualTo(String value) {
            addCriterion("uav_cam_type =", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeNotEqualTo(String value) {
            addCriterion("uav_cam_type <>", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeGreaterThan(String value) {
            addCriterion("uav_cam_type >", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("uav_cam_type >=", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeLessThan(String value) {
            addCriterion("uav_cam_type <", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeLessThanOrEqualTo(String value) {
            addCriterion("uav_cam_type <=", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeLike(String value) {
            addCriterion("uav_cam_type like", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeNotLike(String value) {
            addCriterion("uav_cam_type not like", value, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeIn(List<String> values) {
            addCriterion("uav_cam_type in", values, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeNotIn(List<String> values) {
            addCriterion("uav_cam_type not in", values, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeBetween(String value1, String value2) {
            addCriterion("uav_cam_type between", value1, value2, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavCamTypeNotBetween(String value1, String value2) {
            addCriterion("uav_cam_type not between", value1, value2, "uavCamType");
            return (Criteria) this;
        }

        public Criteria andUavUrlIsNull() {
            addCriterion("uav_url is null");
            return (Criteria) this;
        }

        public Criteria andUavUrlIsNotNull() {
            addCriterion("uav_url is not null");
            return (Criteria) this;
        }

        public Criteria andUavUrlEqualTo(String value) {
            addCriterion("uav_url =", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlNotEqualTo(String value) {
            addCriterion("uav_url <>", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlGreaterThan(String value) {
            addCriterion("uav_url >", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlGreaterThanOrEqualTo(String value) {
            addCriterion("uav_url >=", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlLessThan(String value) {
            addCriterion("uav_url <", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlLessThanOrEqualTo(String value) {
            addCriterion("uav_url <=", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlLike(String value) {
            addCriterion("uav_url like", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlNotLike(String value) {
            addCriterion("uav_url not like", value, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlIn(List<String> values) {
            addCriterion("uav_url in", values, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlNotIn(List<String> values) {
            addCriterion("uav_url not in", values, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlBetween(String value1, String value2) {
            addCriterion("uav_url between", value1, value2, "uavUrl");
            return (Criteria) this;
        }

        public Criteria andUavUrlNotBetween(String value1, String value2) {
            addCriterion("uav_url not between", value1, value2, "uavUrl");
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