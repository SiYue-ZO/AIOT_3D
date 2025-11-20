package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PeopleIllegalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleIllegalExample() {
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

        public Criteria andIllegalIdIsNull() {
            addCriterion("illegal_id is null");
            return (Criteria) this;
        }

        public Criteria andIllegalIdIsNotNull() {
            addCriterion("illegal_id is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalIdEqualTo(String value) {
            addCriterion("illegal_id =", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdNotEqualTo(String value) {
            addCriterion("illegal_id <>", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdGreaterThan(String value) {
            addCriterion("illegal_id >", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_id >=", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdLessThan(String value) {
            addCriterion("illegal_id <", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdLessThanOrEqualTo(String value) {
            addCriterion("illegal_id <=", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdLike(String value) {
            addCriterion("illegal_id like", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdNotLike(String value) {
            addCriterion("illegal_id not like", value, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdIn(List<String> values) {
            addCriterion("illegal_id in", values, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdNotIn(List<String> values) {
            addCriterion("illegal_id not in", values, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdBetween(String value1, String value2) {
            addCriterion("illegal_id between", value1, value2, "illegalId");
            return (Criteria) this;
        }

        public Criteria andIllegalIdNotBetween(String value1, String value2) {
            addCriterion("illegal_id not between", value1, value2, "illegalId");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyIsNull() {
            addCriterion("handle_company is null");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyIsNotNull() {
            addCriterion("handle_company is not null");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyEqualTo(String value) {
            addCriterion("handle_company =", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyNotEqualTo(String value) {
            addCriterion("handle_company <>", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyGreaterThan(String value) {
            addCriterion("handle_company >", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("handle_company >=", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyLessThan(String value) {
            addCriterion("handle_company <", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyLessThanOrEqualTo(String value) {
            addCriterion("handle_company <=", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyLike(String value) {
            addCriterion("handle_company like", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyNotLike(String value) {
            addCriterion("handle_company not like", value, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyIn(List<String> values) {
            addCriterion("handle_company in", values, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyNotIn(List<String> values) {
            addCriterion("handle_company not in", values, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyBetween(String value1, String value2) {
            addCriterion("handle_company between", value1, value2, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleCompanyNotBetween(String value1, String value2) {
            addCriterion("handle_company not between", value1, value2, "handleCompany");
            return (Criteria) this;
        }

        public Criteria andHandleDateIsNull() {
            addCriterion("handle_date is null");
            return (Criteria) this;
        }

        public Criteria andHandleDateIsNotNull() {
            addCriterion("handle_date is not null");
            return (Criteria) this;
        }

        public Criteria andHandleDateEqualTo(String value) {
            addCriterion("handle_date =", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotEqualTo(String value) {
            addCriterion("handle_date <>", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateGreaterThan(String value) {
            addCriterion("handle_date >", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateGreaterThanOrEqualTo(String value) {
            addCriterion("handle_date >=", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateLessThan(String value) {
            addCriterion("handle_date <", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateLessThanOrEqualTo(String value) {
            addCriterion("handle_date <=", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateLike(String value) {
            addCriterion("handle_date like", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotLike(String value) {
            addCriterion("handle_date not like", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateIn(List<String> values) {
            addCriterion("handle_date in", values, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotIn(List<String> values) {
            addCriterion("handle_date not in", values, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateBetween(String value1, String value2) {
            addCriterion("handle_date between", value1, value2, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotBetween(String value1, String value2) {
            addCriterion("handle_date not between", value1, value2, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleModeIsNull() {
            addCriterion("handle_mode is null");
            return (Criteria) this;
        }

        public Criteria andHandleModeIsNotNull() {
            addCriterion("handle_mode is not null");
            return (Criteria) this;
        }

        public Criteria andHandleModeEqualTo(String value) {
            addCriterion("handle_mode =", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeNotEqualTo(String value) {
            addCriterion("handle_mode <>", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeGreaterThan(String value) {
            addCriterion("handle_mode >", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeGreaterThanOrEqualTo(String value) {
            addCriterion("handle_mode >=", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeLessThan(String value) {
            addCriterion("handle_mode <", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeLessThanOrEqualTo(String value) {
            addCriterion("handle_mode <=", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeLike(String value) {
            addCriterion("handle_mode like", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeNotLike(String value) {
            addCriterion("handle_mode not like", value, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeIn(List<String> values) {
            addCriterion("handle_mode in", values, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeNotIn(List<String> values) {
            addCriterion("handle_mode not in", values, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeBetween(String value1, String value2) {
            addCriterion("handle_mode between", value1, value2, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleModeNotBetween(String value1, String value2) {
            addCriterion("handle_mode not between", value1, value2, "handleMode");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNull() {
            addCriterion("handle_result is null");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNotNull() {
            addCriterion("handle_result is not null");
            return (Criteria) this;
        }

        public Criteria andHandleResultEqualTo(String value) {
            addCriterion("handle_result =", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotEqualTo(String value) {
            addCriterion("handle_result <>", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThan(String value) {
            addCriterion("handle_result >", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThanOrEqualTo(String value) {
            addCriterion("handle_result >=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThan(String value) {
            addCriterion("handle_result <", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThanOrEqualTo(String value) {
            addCriterion("handle_result <=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLike(String value) {
            addCriterion("handle_result like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotLike(String value) {
            addCriterion("handle_result not like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultIn(List<String> values) {
            addCriterion("handle_result in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotIn(List<String> values) {
            addCriterion("handle_result not in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultBetween(String value1, String value2) {
            addCriterion("handle_result between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotBetween(String value1, String value2) {
            addCriterion("handle_result not between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleTermIsNull() {
            addCriterion("handle_term is null");
            return (Criteria) this;
        }

        public Criteria andHandleTermIsNotNull() {
            addCriterion("handle_term is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTermEqualTo(String value) {
            addCriterion("handle_term =", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermNotEqualTo(String value) {
            addCriterion("handle_term <>", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermGreaterThan(String value) {
            addCriterion("handle_term >", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermGreaterThanOrEqualTo(String value) {
            addCriterion("handle_term >=", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermLessThan(String value) {
            addCriterion("handle_term <", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermLessThanOrEqualTo(String value) {
            addCriterion("handle_term <=", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermLike(String value) {
            addCriterion("handle_term like", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermNotLike(String value) {
            addCriterion("handle_term not like", value, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermIn(List<String> values) {
            addCriterion("handle_term in", values, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermNotIn(List<String> values) {
            addCriterion("handle_term not in", values, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermBetween(String value1, String value2) {
            addCriterion("handle_term between", value1, value2, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andHandleTermNotBetween(String value1, String value2) {
            addCriterion("handle_term not between", value1, value2, "handleTerm");
            return (Criteria) this;
        }

        public Criteria andIllegalDateIsNull() {
            addCriterion("illegal_date is null");
            return (Criteria) this;
        }

        public Criteria andIllegalDateIsNotNull() {
            addCriterion("illegal_date is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalDateEqualTo(String value) {
            addCriterion("illegal_date =", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateNotEqualTo(String value) {
            addCriterion("illegal_date <>", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateGreaterThan(String value) {
            addCriterion("illegal_date >", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_date >=", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateLessThan(String value) {
            addCriterion("illegal_date <", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateLessThanOrEqualTo(String value) {
            addCriterion("illegal_date <=", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateLike(String value) {
            addCriterion("illegal_date like", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateNotLike(String value) {
            addCriterion("illegal_date not like", value, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateIn(List<String> values) {
            addCriterion("illegal_date in", values, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateNotIn(List<String> values) {
            addCriterion("illegal_date not in", values, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateBetween(String value1, String value2) {
            addCriterion("illegal_date between", value1, value2, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalDateNotBetween(String value1, String value2) {
            addCriterion("illegal_date not between", value1, value2, "illegalDate");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceIsNull() {
            addCriterion("illegal_place is null");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceIsNotNull() {
            addCriterion("illegal_place is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceEqualTo(String value) {
            addCriterion("illegal_place =", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceNotEqualTo(String value) {
            addCriterion("illegal_place <>", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceGreaterThan(String value) {
            addCriterion("illegal_place >", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_place >=", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceLessThan(String value) {
            addCriterion("illegal_place <", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceLessThanOrEqualTo(String value) {
            addCriterion("illegal_place <=", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceLike(String value) {
            addCriterion("illegal_place like", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceNotLike(String value) {
            addCriterion("illegal_place not like", value, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceIn(List<String> values) {
            addCriterion("illegal_place in", values, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceNotIn(List<String> values) {
            addCriterion("illegal_place not in", values, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceBetween(String value1, String value2) {
            addCriterion("illegal_place between", value1, value2, "illegalPlace");
            return (Criteria) this;
        }

        public Criteria andIllegalPlaceNotBetween(String value1, String value2) {
            addCriterion("illegal_place not between", value1, value2, "illegalPlace");
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