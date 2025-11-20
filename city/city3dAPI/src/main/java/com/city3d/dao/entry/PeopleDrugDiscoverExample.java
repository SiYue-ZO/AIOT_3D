package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PeopleDrugDiscoverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleDrugDiscoverExample() {
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

        public Criteria andDrugDiscoverIdIsNull() {
            addCriterion("drug_discover_id is null");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdIsNotNull() {
            addCriterion("drug_discover_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdEqualTo(String value) {
            addCriterion("drug_discover_id =", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdNotEqualTo(String value) {
            addCriterion("drug_discover_id <>", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdGreaterThan(String value) {
            addCriterion("drug_discover_id >", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("drug_discover_id >=", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdLessThan(String value) {
            addCriterion("drug_discover_id <", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdLessThanOrEqualTo(String value) {
            addCriterion("drug_discover_id <=", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdLike(String value) {
            addCriterion("drug_discover_id like", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdNotLike(String value) {
            addCriterion("drug_discover_id not like", value, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdIn(List<String> values) {
            addCriterion("drug_discover_id in", values, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdNotIn(List<String> values) {
            addCriterion("drug_discover_id not in", values, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdBetween(String value1, String value2) {
            addCriterion("drug_discover_id between", value1, value2, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andDrugDiscoverIdNotBetween(String value1, String value2) {
            addCriterion("drug_discover_id not between", value1, value2, "drugDiscoverId");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("case_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("case_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(String value) {
            addCriterion("case_type =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(String value) {
            addCriterion("case_type <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(String value) {
            addCriterion("case_type >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("case_type >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(String value) {
            addCriterion("case_type <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(String value) {
            addCriterion("case_type <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLike(String value) {
            addCriterion("case_type like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotLike(String value) {
            addCriterion("case_type not like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<String> values) {
            addCriterion("case_type in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<String> values) {
            addCriterion("case_type not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(String value1, String value2) {
            addCriterion("case_type between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(String value1, String value2) {
            addCriterion("case_type not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNull() {
            addCriterion("pp_id is null");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNotNull() {
            addCriterion("pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpIdEqualTo(String value) {
            addCriterion("pp_id =", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotEqualTo(String value) {
            addCriterion("pp_id <>", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThan(String value) {
            addCriterion("pp_id >", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThanOrEqualTo(String value) {
            addCriterion("pp_id >=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThan(String value) {
            addCriterion("pp_id <", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThanOrEqualTo(String value) {
            addCriterion("pp_id <=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLike(String value) {
            addCriterion("pp_id like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotLike(String value) {
            addCriterion("pp_id not like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdIn(List<String> values) {
            addCriterion("pp_id in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotIn(List<String> values) {
            addCriterion("pp_id not in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdBetween(String value1, String value2) {
            addCriterion("pp_id between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotBetween(String value1, String value2) {
            addCriterion("pp_id not between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedIsNull() {
            addCriterion("results_obtained is null");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedIsNotNull() {
            addCriterion("results_obtained is not null");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedEqualTo(String value) {
            addCriterion("results_obtained =", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedNotEqualTo(String value) {
            addCriterion("results_obtained <>", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedGreaterThan(String value) {
            addCriterion("results_obtained >", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedGreaterThanOrEqualTo(String value) {
            addCriterion("results_obtained >=", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedLessThan(String value) {
            addCriterion("results_obtained <", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedLessThanOrEqualTo(String value) {
            addCriterion("results_obtained <=", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedLike(String value) {
            addCriterion("results_obtained like", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedNotLike(String value) {
            addCriterion("results_obtained not like", value, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedIn(List<String> values) {
            addCriterion("results_obtained in", values, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedNotIn(List<String> values) {
            addCriterion("results_obtained not in", values, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedBetween(String value1, String value2) {
            addCriterion("results_obtained between", value1, value2, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andResultsObtainedNotBetween(String value1, String value2) {
            addCriterion("results_obtained not between", value1, value2, "resultsObtained");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitIsNull() {
            addCriterion("seized_unit is null");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitIsNotNull() {
            addCriterion("seized_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitEqualTo(String value) {
            addCriterion("seized_unit =", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitNotEqualTo(String value) {
            addCriterion("seized_unit <>", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitGreaterThan(String value) {
            addCriterion("seized_unit >", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitGreaterThanOrEqualTo(String value) {
            addCriterion("seized_unit >=", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitLessThan(String value) {
            addCriterion("seized_unit <", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitLessThanOrEqualTo(String value) {
            addCriterion("seized_unit <=", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitLike(String value) {
            addCriterion("seized_unit like", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitNotLike(String value) {
            addCriterion("seized_unit not like", value, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitIn(List<String> values) {
            addCriterion("seized_unit in", values, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitNotIn(List<String> values) {
            addCriterion("seized_unit not in", values, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitBetween(String value1, String value2) {
            addCriterion("seized_unit between", value1, value2, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizedUnitNotBetween(String value1, String value2) {
            addCriterion("seized_unit not between", value1, value2, "seizedUnit");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeIsNull() {
            addCriterion("seizure_time is null");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeIsNotNull() {
            addCriterion("seizure_time is not null");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeEqualTo(String value) {
            addCriterion("seizure_time =", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeNotEqualTo(String value) {
            addCriterion("seizure_time <>", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeGreaterThan(String value) {
            addCriterion("seizure_time >", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeGreaterThanOrEqualTo(String value) {
            addCriterion("seizure_time >=", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeLessThan(String value) {
            addCriterion("seizure_time <", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeLessThanOrEqualTo(String value) {
            addCriterion("seizure_time <=", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeLike(String value) {
            addCriterion("seizure_time like", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeNotLike(String value) {
            addCriterion("seizure_time not like", value, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeIn(List<String> values) {
            addCriterion("seizure_time in", values, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeNotIn(List<String> values) {
            addCriterion("seizure_time not in", values, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeBetween(String value1, String value2) {
            addCriterion("seizure_time between", value1, value2, "seizureTime");
            return (Criteria) this;
        }

        public Criteria andSeizureTimeNotBetween(String value1, String value2) {
            addCriterion("seizure_time not between", value1, value2, "seizureTime");
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