package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class DatalayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatalayerExample() {
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

        public Criteria andLayerIdIsNull() {
            addCriterion("layer_id is null");
            return (Criteria) this;
        }

        public Criteria andLayerIdIsNotNull() {
            addCriterion("layer_id is not null");
            return (Criteria) this;
        }

        public Criteria andLayerIdEqualTo(String value) {
            addCriterion("layer_id =", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotEqualTo(String value) {
            addCriterion("layer_id <>", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdGreaterThan(String value) {
            addCriterion("layer_id >", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("layer_id >=", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLessThan(String value) {
            addCriterion("layer_id <", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLessThanOrEqualTo(String value) {
            addCriterion("layer_id <=", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLike(String value) {
            addCriterion("layer_id like", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotLike(String value) {
            addCriterion("layer_id not like", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdIn(List<String> values) {
            addCriterion("layer_id in", values, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotIn(List<String> values) {
            addCriterion("layer_id not in", values, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdBetween(String value1, String value2) {
            addCriterion("layer_id between", value1, value2, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotBetween(String value1, String value2) {
            addCriterion("layer_id not between", value1, value2, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNull() {
            addCriterion("layer_name is null");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNotNull() {
            addCriterion("layer_name is not null");
            return (Criteria) this;
        }

        public Criteria andLayerNameEqualTo(String value) {
            addCriterion("layer_name =", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotEqualTo(String value) {
            addCriterion("layer_name <>", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThan(String value) {
            addCriterion("layer_name >", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("layer_name >=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThan(String value) {
            addCriterion("layer_name <", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThanOrEqualTo(String value) {
            addCriterion("layer_name <=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLike(String value) {
            addCriterion("layer_name like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotLike(String value) {
            addCriterion("layer_name not like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameIn(List<String> values) {
            addCriterion("layer_name in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotIn(List<String> values) {
            addCriterion("layer_name not in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameBetween(String value1, String value2) {
            addCriterion("layer_name between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotBetween(String value1, String value2) {
            addCriterion("layer_name not between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIsNull() {
            addCriterion("layer_type is null");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIsNotNull() {
            addCriterion("layer_type is not null");
            return (Criteria) this;
        }

        public Criteria andLayerTypeEqualTo(String value) {
            addCriterion("layer_type =", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotEqualTo(String value) {
            addCriterion("layer_type <>", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeGreaterThan(String value) {
            addCriterion("layer_type >", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("layer_type >=", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLessThan(String value) {
            addCriterion("layer_type <", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLessThanOrEqualTo(String value) {
            addCriterion("layer_type <=", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLike(String value) {
            addCriterion("layer_type like", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotLike(String value) {
            addCriterion("layer_type not like", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIn(List<String> values) {
            addCriterion("layer_type in", values, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotIn(List<String> values) {
            addCriterion("layer_type not in", values, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeBetween(String value1, String value2) {
            addCriterion("layer_type between", value1, value2, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotBetween(String value1, String value2) {
            addCriterion("layer_type not between", value1, value2, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerFormatIsNull() {
            addCriterion("layer_format is null");
            return (Criteria) this;
        }

        public Criteria andLayerFormatIsNotNull() {
            addCriterion("layer_format is not null");
            return (Criteria) this;
        }

        public Criteria andLayerFormatEqualTo(String value) {
            addCriterion("layer_format =", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatNotEqualTo(String value) {
            addCriterion("layer_format <>", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatGreaterThan(String value) {
            addCriterion("layer_format >", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatGreaterThanOrEqualTo(String value) {
            addCriterion("layer_format >=", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatLessThan(String value) {
            addCriterion("layer_format <", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatLessThanOrEqualTo(String value) {
            addCriterion("layer_format <=", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatLike(String value) {
            addCriterion("layer_format like", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatNotLike(String value) {
            addCriterion("layer_format not like", value, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatIn(List<String> values) {
            addCriterion("layer_format in", values, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatNotIn(List<String> values) {
            addCriterion("layer_format not in", values, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatBetween(String value1, String value2) {
            addCriterion("layer_format between", value1, value2, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerFormatNotBetween(String value1, String value2) {
            addCriterion("layer_format not between", value1, value2, "layerFormat");
            return (Criteria) this;
        }

        public Criteria andLayerPidIsNull() {
            addCriterion("layer_pid is null");
            return (Criteria) this;
        }

        public Criteria andLayerPidIsNotNull() {
            addCriterion("layer_pid is not null");
            return (Criteria) this;
        }

        public Criteria andLayerPidEqualTo(String value) {
            addCriterion("layer_pid =", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidNotEqualTo(String value) {
            addCriterion("layer_pid <>", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidGreaterThan(String value) {
            addCriterion("layer_pid >", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidGreaterThanOrEqualTo(String value) {
            addCriterion("layer_pid >=", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidLessThan(String value) {
            addCriterion("layer_pid <", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidLessThanOrEqualTo(String value) {
            addCriterion("layer_pid <=", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidLike(String value) {
            addCriterion("layer_pid like", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidNotLike(String value) {
            addCriterion("layer_pid not like", value, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidIn(List<String> values) {
            addCriterion("layer_pid in", values, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidNotIn(List<String> values) {
            addCriterion("layer_pid not in", values, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidBetween(String value1, String value2) {
            addCriterion("layer_pid between", value1, value2, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPidNotBetween(String value1, String value2) {
            addCriterion("layer_pid not between", value1, value2, "layerPid");
            return (Criteria) this;
        }

        public Criteria andLayerPathIsNull() {
            addCriterion("layer_path is null");
            return (Criteria) this;
        }

        public Criteria andLayerPathIsNotNull() {
            addCriterion("layer_path is not null");
            return (Criteria) this;
        }

        public Criteria andLayerPathEqualTo(String value) {
            addCriterion("layer_path =", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathNotEqualTo(String value) {
            addCriterion("layer_path <>", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathGreaterThan(String value) {
            addCriterion("layer_path >", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathGreaterThanOrEqualTo(String value) {
            addCriterion("layer_path >=", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathLessThan(String value) {
            addCriterion("layer_path <", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathLessThanOrEqualTo(String value) {
            addCriterion("layer_path <=", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathLike(String value) {
            addCriterion("layer_path like", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathNotLike(String value) {
            addCriterion("layer_path not like", value, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathIn(List<String> values) {
            addCriterion("layer_path in", values, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathNotIn(List<String> values) {
            addCriterion("layer_path not in", values, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathBetween(String value1, String value2) {
            addCriterion("layer_path between", value1, value2, "layerPath");
            return (Criteria) this;
        }

        public Criteria andLayerPathNotBetween(String value1, String value2) {
            addCriterion("layer_path not between", value1, value2, "layerPath");
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