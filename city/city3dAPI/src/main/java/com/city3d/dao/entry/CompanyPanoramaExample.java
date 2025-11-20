package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CompanyPanoramaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPanoramaExample() {
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

        public Criteria andPanoramaIdIsNull() {
            addCriterion("panorama_id is null");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdIsNotNull() {
            addCriterion("panorama_id is not null");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdEqualTo(String value) {
            addCriterion("panorama_id =", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotEqualTo(String value) {
            addCriterion("panorama_id <>", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdGreaterThan(String value) {
            addCriterion("panorama_id >", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdGreaterThanOrEqualTo(String value) {
            addCriterion("panorama_id >=", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLessThan(String value) {
            addCriterion("panorama_id <", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLessThanOrEqualTo(String value) {
            addCriterion("panorama_id <=", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLike(String value) {
            addCriterion("panorama_id like", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotLike(String value) {
            addCriterion("panorama_id not like", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdIn(List<String> values) {
            addCriterion("panorama_id in", values, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotIn(List<String> values) {
            addCriterion("panorama_id not in", values, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdBetween(String value1, String value2) {
            addCriterion("panorama_id between", value1, value2, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotBetween(String value1, String value2) {
            addCriterion("panorama_id not between", value1, value2, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaIsNull() {
            addCriterion("company_panorama is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaIsNotNull() {
            addCriterion("company_panorama is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaEqualTo(String value) {
            addCriterion("company_panorama =", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaNotEqualTo(String value) {
            addCriterion("company_panorama <>", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaGreaterThan(String value) {
            addCriterion("company_panorama >", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaGreaterThanOrEqualTo(String value) {
            addCriterion("company_panorama >=", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaLessThan(String value) {
            addCriterion("company_panorama <", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaLessThanOrEqualTo(String value) {
            addCriterion("company_panorama <=", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaLike(String value) {
            addCriterion("company_panorama like", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaNotLike(String value) {
            addCriterion("company_panorama not like", value, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaIn(List<String> values) {
            addCriterion("company_panorama in", values, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaNotIn(List<String> values) {
            addCriterion("company_panorama not in", values, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaBetween(String value1, String value2) {
            addCriterion("company_panorama between", value1, value2, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPanoramaNotBetween(String value1, String value2) {
            addCriterion("company_panorama not between", value1, value2, "companyPanorama");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternIsNull() {
            addCriterion("company_pattern is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternIsNotNull() {
            addCriterion("company_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternEqualTo(String value) {
            addCriterion("company_pattern =", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternNotEqualTo(String value) {
            addCriterion("company_pattern <>", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternGreaterThan(String value) {
            addCriterion("company_pattern >", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternGreaterThanOrEqualTo(String value) {
            addCriterion("company_pattern >=", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternLessThan(String value) {
            addCriterion("company_pattern <", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternLessThanOrEqualTo(String value) {
            addCriterion("company_pattern <=", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternLike(String value) {
            addCriterion("company_pattern like", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternNotLike(String value) {
            addCriterion("company_pattern not like", value, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternIn(List<String> values) {
            addCriterion("company_pattern in", values, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternNotIn(List<String> values) {
            addCriterion("company_pattern not in", values, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternBetween(String value1, String value2) {
            addCriterion("company_pattern between", value1, value2, "companyPattern");
            return (Criteria) this;
        }

        public Criteria andCompanyPatternNotBetween(String value1, String value2) {
            addCriterion("company_pattern not between", value1, value2, "companyPattern");
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