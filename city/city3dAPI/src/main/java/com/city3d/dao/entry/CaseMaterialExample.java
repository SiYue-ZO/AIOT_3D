package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CaseMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseMaterialExample() {
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

        public Criteria andCaseMaterialIdIsNull() {
            addCriterion("case_material_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdIsNotNull() {
            addCriterion("case_material_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdEqualTo(String value) {
            addCriterion("case_material_id =", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdNotEqualTo(String value) {
            addCriterion("case_material_id <>", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdGreaterThan(String value) {
            addCriterion("case_material_id >", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("case_material_id >=", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdLessThan(String value) {
            addCriterion("case_material_id <", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("case_material_id <=", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdLike(String value) {
            addCriterion("case_material_id like", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdNotLike(String value) {
            addCriterion("case_material_id not like", value, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdIn(List<String> values) {
            addCriterion("case_material_id in", values, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdNotIn(List<String> values) {
            addCriterion("case_material_id not in", values, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdBetween(String value1, String value2) {
            addCriterion("case_material_id between", value1, value2, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseMaterialIdNotBetween(String value1, String value2) {
            addCriterion("case_material_id not between", value1, value2, "caseMaterialId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(String value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(String value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(String value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(String value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(String value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(String value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLike(String value) {
            addCriterion("case_id like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotLike(String value) {
            addCriterion("case_id not like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<String> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<String> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(String value1, String value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(String value1, String value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIsNull() {
            addCriterion("material_url is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIsNotNull() {
            addCriterion("material_url is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlEqualTo(String value) {
            addCriterion("material_url =", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotEqualTo(String value) {
            addCriterion("material_url <>", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlGreaterThan(String value) {
            addCriterion("material_url >", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlGreaterThanOrEqualTo(String value) {
            addCriterion("material_url >=", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLessThan(String value) {
            addCriterion("material_url <", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLessThanOrEqualTo(String value) {
            addCriterion("material_url <=", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLike(String value) {
            addCriterion("material_url like", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotLike(String value) {
            addCriterion("material_url not like", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIn(List<String> values) {
            addCriterion("material_url in", values, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotIn(List<String> values) {
            addCriterion("material_url not in", values, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlBetween(String value1, String value2) {
            addCriterion("material_url between", value1, value2, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotBetween(String value1, String value2) {
            addCriterion("material_url not between", value1, value2, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
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