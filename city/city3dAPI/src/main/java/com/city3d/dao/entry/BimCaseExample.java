package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class BimCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BimCaseExample() {
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

        public Criteria andBimCaseIdIsNull() {
            addCriterion("bim_case_id is null");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdIsNotNull() {
            addCriterion("bim_case_id is not null");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdEqualTo(String value) {
            addCriterion("bim_case_id =", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdNotEqualTo(String value) {
            addCriterion("bim_case_id <>", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdGreaterThan(String value) {
            addCriterion("bim_case_id >", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdGreaterThanOrEqualTo(String value) {
            addCriterion("bim_case_id >=", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdLessThan(String value) {
            addCriterion("bim_case_id <", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdLessThanOrEqualTo(String value) {
            addCriterion("bim_case_id <=", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdLike(String value) {
            addCriterion("bim_case_id like", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdNotLike(String value) {
            addCriterion("bim_case_id not like", value, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdIn(List<String> values) {
            addCriterion("bim_case_id in", values, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdNotIn(List<String> values) {
            addCriterion("bim_case_id not in", values, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdBetween(String value1, String value2) {
            addCriterion("bim_case_id between", value1, value2, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseIdNotBetween(String value1, String value2) {
            addCriterion("bim_case_id not between", value1, value2, "bimCaseId");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameIsNull() {
            addCriterion("bim_case_name is null");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameIsNotNull() {
            addCriterion("bim_case_name is not null");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameEqualTo(String value) {
            addCriterion("bim_case_name =", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameNotEqualTo(String value) {
            addCriterion("bim_case_name <>", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameGreaterThan(String value) {
            addCriterion("bim_case_name >", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("bim_case_name >=", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameLessThan(String value) {
            addCriterion("bim_case_name <", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameLessThanOrEqualTo(String value) {
            addCriterion("bim_case_name <=", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameLike(String value) {
            addCriterion("bim_case_name like", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameNotLike(String value) {
            addCriterion("bim_case_name not like", value, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameIn(List<String> values) {
            addCriterion("bim_case_name in", values, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameNotIn(List<String> values) {
            addCriterion("bim_case_name not in", values, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameBetween(String value1, String value2) {
            addCriterion("bim_case_name between", value1, value2, "bimCaseName");
            return (Criteria) this;
        }

        public Criteria andBimCaseNameNotBetween(String value1, String value2) {
            addCriterion("bim_case_name not between", value1, value2, "bimCaseName");
            return (Criteria) this;
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

        public Criteria andModelPosIsNull() {
            addCriterion("model_pos is null");
            return (Criteria) this;
        }

        public Criteria andModelPosIsNotNull() {
            addCriterion("model_pos is not null");
            return (Criteria) this;
        }

        public Criteria andModelPosEqualTo(String value) {
            addCriterion("model_pos =", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosNotEqualTo(String value) {
            addCriterion("model_pos <>", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosGreaterThan(String value) {
            addCriterion("model_pos >", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosGreaterThanOrEqualTo(String value) {
            addCriterion("model_pos >=", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosLessThan(String value) {
            addCriterion("model_pos <", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosLessThanOrEqualTo(String value) {
            addCriterion("model_pos <=", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosLike(String value) {
            addCriterion("model_pos like", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosNotLike(String value) {
            addCriterion("model_pos not like", value, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosIn(List<String> values) {
            addCriterion("model_pos in", values, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosNotIn(List<String> values) {
            addCriterion("model_pos not in", values, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosBetween(String value1, String value2) {
            addCriterion("model_pos between", value1, value2, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelPosNotBetween(String value1, String value2) {
            addCriterion("model_pos not between", value1, value2, "modelPos");
            return (Criteria) this;
        }

        public Criteria andModelHeadingIsNull() {
            addCriterion("model_heading is null");
            return (Criteria) this;
        }

        public Criteria andModelHeadingIsNotNull() {
            addCriterion("model_heading is not null");
            return (Criteria) this;
        }

        public Criteria andModelHeadingEqualTo(String value) {
            addCriterion("model_heading =", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingNotEqualTo(String value) {
            addCriterion("model_heading <>", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingGreaterThan(String value) {
            addCriterion("model_heading >", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("model_heading >=", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingLessThan(String value) {
            addCriterion("model_heading <", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingLessThanOrEqualTo(String value) {
            addCriterion("model_heading <=", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingLike(String value) {
            addCriterion("model_heading like", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingNotLike(String value) {
            addCriterion("model_heading not like", value, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingIn(List<String> values) {
            addCriterion("model_heading in", values, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingNotIn(List<String> values) {
            addCriterion("model_heading not in", values, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingBetween(String value1, String value2) {
            addCriterion("model_heading between", value1, value2, "modelHeading");
            return (Criteria) this;
        }

        public Criteria andModelHeadingNotBetween(String value1, String value2) {
            addCriterion("model_heading not between", value1, value2, "modelHeading");
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

        public Criteria andFlattenPosIsNull() {
            addCriterion("flatten_pos is null");
            return (Criteria) this;
        }

        public Criteria andFlattenPosIsNotNull() {
            addCriterion("flatten_pos is not null");
            return (Criteria) this;
        }

        public Criteria andFlattenPosEqualTo(String value) {
            addCriterion("flatten_pos =", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosNotEqualTo(String value) {
            addCriterion("flatten_pos <>", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosGreaterThan(String value) {
            addCriterion("flatten_pos >", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosGreaterThanOrEqualTo(String value) {
            addCriterion("flatten_pos >=", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosLessThan(String value) {
            addCriterion("flatten_pos <", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosLessThanOrEqualTo(String value) {
            addCriterion("flatten_pos <=", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosLike(String value) {
            addCriterion("flatten_pos like", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosNotLike(String value) {
            addCriterion("flatten_pos not like", value, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosIn(List<String> values) {
            addCriterion("flatten_pos in", values, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosNotIn(List<String> values) {
            addCriterion("flatten_pos not in", values, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosBetween(String value1, String value2) {
            addCriterion("flatten_pos between", value1, value2, "flattenPos");
            return (Criteria) this;
        }

        public Criteria andFlattenPosNotBetween(String value1, String value2) {
            addCriterion("flatten_pos not between", value1, value2, "flattenPos");
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