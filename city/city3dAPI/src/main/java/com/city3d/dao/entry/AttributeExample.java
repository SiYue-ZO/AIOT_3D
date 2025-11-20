package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class AttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttributeExample() {
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

        public Criteria andAttrNameIsNull() {
            addCriterion("attr_name is null");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNotNull() {
            addCriterion("attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrNameEqualTo(String value) {
            addCriterion("attr_name =", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotEqualTo(String value) {
            addCriterion("attr_name <>", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThan(String value) {
            addCriterion("attr_name >", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("attr_name >=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThan(String value) {
            addCriterion("attr_name <", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThanOrEqualTo(String value) {
            addCriterion("attr_name <=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLike(String value) {
            addCriterion("attr_name like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotLike(String value) {
            addCriterion("attr_name not like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameIn(List<String> values) {
            addCriterion("attr_name in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotIn(List<String> values) {
            addCriterion("attr_name not in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameBetween(String value1, String value2) {
            addCriterion("attr_name between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotBetween(String value1, String value2) {
            addCriterion("attr_name not between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOptionIsNull() {
            addCriterion("option is null");
            return (Criteria) this;
        }

        public Criteria andOptionIsNotNull() {
            addCriterion("option is not null");
            return (Criteria) this;
        }

        public Criteria andOptionEqualTo(String value) {
            addCriterion("option =", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotEqualTo(String value) {
            addCriterion("option <>", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThan(String value) {
            addCriterion("option >", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionGreaterThanOrEqualTo(String value) {
            addCriterion("option >=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThan(String value) {
            addCriterion("option <", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLessThanOrEqualTo(String value) {
            addCriterion("option <=", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionLike(String value) {
            addCriterion("option like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotLike(String value) {
            addCriterion("option not like", value, "option");
            return (Criteria) this;
        }

        public Criteria andOptionIn(List<String> values) {
            addCriterion("option in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotIn(List<String> values) {
            addCriterion("option not in", values, "option");
            return (Criteria) this;
        }

        public Criteria andOptionBetween(String value1, String value2) {
            addCriterion("option between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andOptionNotBetween(String value1, String value2) {
            addCriterion("option not between", value1, value2, "option");
            return (Criteria) this;
        }

        public Criteria andNormalValueIsNull() {
            addCriterion("normal_value is null");
            return (Criteria) this;
        }

        public Criteria andNormalValueIsNotNull() {
            addCriterion("normal_value is not null");
            return (Criteria) this;
        }

        public Criteria andNormalValueEqualTo(String value) {
            addCriterion("normal_value =", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueNotEqualTo(String value) {
            addCriterion("normal_value <>", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueGreaterThan(String value) {
            addCriterion("normal_value >", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueGreaterThanOrEqualTo(String value) {
            addCriterion("normal_value >=", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueLessThan(String value) {
            addCriterion("normal_value <", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueLessThanOrEqualTo(String value) {
            addCriterion("normal_value <=", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueLike(String value) {
            addCriterion("normal_value like", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueNotLike(String value) {
            addCriterion("normal_value not like", value, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueIn(List<String> values) {
            addCriterion("normal_value in", values, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueNotIn(List<String> values) {
            addCriterion("normal_value not in", values, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueBetween(String value1, String value2) {
            addCriterion("normal_value between", value1, value2, "normalValue");
            return (Criteria) this;
        }

        public Criteria andNormalValueNotBetween(String value1, String value2) {
            addCriterion("normal_value not between", value1, value2, "normalValue");
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

        public Criteria andSelectNumIsNull() {
            addCriterion("select_num is null");
            return (Criteria) this;
        }

        public Criteria andSelectNumIsNotNull() {
            addCriterion("select_num is not null");
            return (Criteria) this;
        }

        public Criteria andSelectNumEqualTo(String value) {
            addCriterion("select_num =", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotEqualTo(String value) {
            addCriterion("select_num <>", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumGreaterThan(String value) {
            addCriterion("select_num >", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumGreaterThanOrEqualTo(String value) {
            addCriterion("select_num >=", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumLessThan(String value) {
            addCriterion("select_num <", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumLessThanOrEqualTo(String value) {
            addCriterion("select_num <=", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumLike(String value) {
            addCriterion("select_num like", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotLike(String value) {
            addCriterion("select_num not like", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumIn(List<String> values) {
            addCriterion("select_num in", values, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotIn(List<String> values) {
            addCriterion("select_num not in", values, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumBetween(String value1, String value2) {
            addCriterion("select_num between", value1, value2, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotBetween(String value1, String value2) {
            addCriterion("select_num not between", value1, value2, "selectNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
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