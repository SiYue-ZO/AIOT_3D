package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class ModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelDepIsNull() {
            addCriterion("model_dep is null");
            return (Criteria) this;
        }

        public Criteria andModelDepIsNotNull() {
            addCriterion("model_dep is not null");
            return (Criteria) this;
        }

        public Criteria andModelDepEqualTo(String value) {
            addCriterion("model_dep =", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepNotEqualTo(String value) {
            addCriterion("model_dep <>", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepGreaterThan(String value) {
            addCriterion("model_dep >", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepGreaterThanOrEqualTo(String value) {
            addCriterion("model_dep >=", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepLessThan(String value) {
            addCriterion("model_dep <", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepLessThanOrEqualTo(String value) {
            addCriterion("model_dep <=", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepLike(String value) {
            addCriterion("model_dep like", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepNotLike(String value) {
            addCriterion("model_dep not like", value, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepIn(List<String> values) {
            addCriterion("model_dep in", values, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepNotIn(List<String> values) {
            addCriterion("model_dep not in", values, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepBetween(String value1, String value2) {
            addCriterion("model_dep between", value1, value2, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelDepNotBetween(String value1, String value2) {
            addCriterion("model_dep not between", value1, value2, "modelDep");
            return (Criteria) this;
        }

        public Criteria andModelUrlIsNull() {
            addCriterion("model_url is null");
            return (Criteria) this;
        }

        public Criteria andModelUrlIsNotNull() {
            addCriterion("model_url is not null");
            return (Criteria) this;
        }

        public Criteria andModelUrlEqualTo(String value) {
            addCriterion("model_url =", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotEqualTo(String value) {
            addCriterion("model_url <>", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlGreaterThan(String value) {
            addCriterion("model_url >", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("model_url >=", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLessThan(String value) {
            addCriterion("model_url <", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLessThanOrEqualTo(String value) {
            addCriterion("model_url <=", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlLike(String value) {
            addCriterion("model_url like", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotLike(String value) {
            addCriterion("model_url not like", value, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlIn(List<String> values) {
            addCriterion("model_url in", values, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotIn(List<String> values) {
            addCriterion("model_url not in", values, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlBetween(String value1, String value2) {
            addCriterion("model_url between", value1, value2, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelUrlNotBetween(String value1, String value2) {
            addCriterion("model_url not between", value1, value2, "modelUrl");
            return (Criteria) this;
        }

        public Criteria andModelImgIsNull() {
            addCriterion("model_img is null");
            return (Criteria) this;
        }

        public Criteria andModelImgIsNotNull() {
            addCriterion("model_img is not null");
            return (Criteria) this;
        }

        public Criteria andModelImgEqualTo(String value) {
            addCriterion("model_img =", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgNotEqualTo(String value) {
            addCriterion("model_img <>", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgGreaterThan(String value) {
            addCriterion("model_img >", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgGreaterThanOrEqualTo(String value) {
            addCriterion("model_img >=", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgLessThan(String value) {
            addCriterion("model_img <", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgLessThanOrEqualTo(String value) {
            addCriterion("model_img <=", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgLike(String value) {
            addCriterion("model_img like", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgNotLike(String value) {
            addCriterion("model_img not like", value, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgIn(List<String> values) {
            addCriterion("model_img in", values, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgNotIn(List<String> values) {
            addCriterion("model_img not in", values, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgBetween(String value1, String value2) {
            addCriterion("model_img between", value1, value2, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelImgNotBetween(String value1, String value2) {
            addCriterion("model_img not between", value1, value2, "modelImg");
            return (Criteria) this;
        }

        public Criteria andModelScaleIsNull() {
            addCriterion("model_scale is null");
            return (Criteria) this;
        }

        public Criteria andModelScaleIsNotNull() {
            addCriterion("model_scale is not null");
            return (Criteria) this;
        }

        public Criteria andModelScaleEqualTo(String value) {
            addCriterion("model_scale =", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleNotEqualTo(String value) {
            addCriterion("model_scale <>", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleGreaterThan(String value) {
            addCriterion("model_scale >", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleGreaterThanOrEqualTo(String value) {
            addCriterion("model_scale >=", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleLessThan(String value) {
            addCriterion("model_scale <", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleLessThanOrEqualTo(String value) {
            addCriterion("model_scale <=", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleLike(String value) {
            addCriterion("model_scale like", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleNotLike(String value) {
            addCriterion("model_scale not like", value, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleIn(List<String> values) {
            addCriterion("model_scale in", values, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleNotIn(List<String> values) {
            addCriterion("model_scale not in", values, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleBetween(String value1, String value2) {
            addCriterion("model_scale between", value1, value2, "modelScale");
            return (Criteria) this;
        }

        public Criteria andModelScaleNotBetween(String value1, String value2) {
            addCriterion("model_scale not between", value1, value2, "modelScale");
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