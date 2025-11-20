package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CompanyCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyCheckExample() {
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

        public Criteria andCompanyCheckIdIsNull() {
            addCriterion("company_check_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdIsNotNull() {
            addCriterion("company_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdEqualTo(String value) {
            addCriterion("company_check_id =", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdNotEqualTo(String value) {
            addCriterion("company_check_id <>", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdGreaterThan(String value) {
            addCriterion("company_check_id >", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_check_id >=", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdLessThan(String value) {
            addCriterion("company_check_id <", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdLessThanOrEqualTo(String value) {
            addCriterion("company_check_id <=", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdLike(String value) {
            addCriterion("company_check_id like", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdNotLike(String value) {
            addCriterion("company_check_id not like", value, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdIn(List<String> values) {
            addCriterion("company_check_id in", values, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdNotIn(List<String> values) {
            addCriterion("company_check_id not in", values, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdBetween(String value1, String value2) {
            addCriterion("company_check_id between", value1, value2, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andCompanyCheckIdNotBetween(String value1, String value2) {
            addCriterion("company_check_id not between", value1, value2, "companyCheckId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andCheckContentIsNull() {
            addCriterion("check_content is null");
            return (Criteria) this;
        }

        public Criteria andCheckContentIsNotNull() {
            addCriterion("check_content is not null");
            return (Criteria) this;
        }

        public Criteria andCheckContentEqualTo(String value) {
            addCriterion("check_content =", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotEqualTo(String value) {
            addCriterion("check_content <>", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentGreaterThan(String value) {
            addCriterion("check_content >", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentGreaterThanOrEqualTo(String value) {
            addCriterion("check_content >=", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLessThan(String value) {
            addCriterion("check_content <", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLessThanOrEqualTo(String value) {
            addCriterion("check_content <=", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentLike(String value) {
            addCriterion("check_content like", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotLike(String value) {
            addCriterion("check_content not like", value, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentIn(List<String> values) {
            addCriterion("check_content in", values, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotIn(List<String> values) {
            addCriterion("check_content not in", values, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentBetween(String value1, String value2) {
            addCriterion("check_content between", value1, value2, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckContentNotBetween(String value1, String value2) {
            addCriterion("check_content not between", value1, value2, "checkContent");
            return (Criteria) this;
        }

        public Criteria andCheckManIsNull() {
            addCriterion("check_man is null");
            return (Criteria) this;
        }

        public Criteria andCheckManIsNotNull() {
            addCriterion("check_man is not null");
            return (Criteria) this;
        }

        public Criteria andCheckManEqualTo(String value) {
            addCriterion("check_man =", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotEqualTo(String value) {
            addCriterion("check_man <>", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManGreaterThan(String value) {
            addCriterion("check_man >", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManGreaterThanOrEqualTo(String value) {
            addCriterion("check_man >=", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLessThan(String value) {
            addCriterion("check_man <", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLessThanOrEqualTo(String value) {
            addCriterion("check_man <=", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLike(String value) {
            addCriterion("check_man like", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotLike(String value) {
            addCriterion("check_man not like", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManIn(List<String> values) {
            addCriterion("check_man in", values, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotIn(List<String> values) {
            addCriterion("check_man not in", values, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManBetween(String value1, String value2) {
            addCriterion("check_man between", value1, value2, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotBetween(String value1, String value2) {
            addCriterion("check_man not between", value1, value2, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNull() {
            addCriterion("check_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNotNull() {
            addCriterion("check_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNameEqualTo(String value) {
            addCriterion("check_name =", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotEqualTo(String value) {
            addCriterion("check_name <>", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThan(String value) {
            addCriterion("check_name >", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_name >=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThan(String value) {
            addCriterion("check_name <", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThanOrEqualTo(String value) {
            addCriterion("check_name <=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLike(String value) {
            addCriterion("check_name like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotLike(String value) {
            addCriterion("check_name not like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameIn(List<String> values) {
            addCriterion("check_name in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotIn(List<String> values) {
            addCriterion("check_name not in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameBetween(String value1, String value2) {
            addCriterion("check_name between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotBetween(String value1, String value2) {
            addCriterion("check_name not between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIsNull() {
            addCriterion("check_number is null");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIsNotNull() {
            addCriterion("check_number is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNumberEqualTo(String value) {
            addCriterion("check_number =", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotEqualTo(String value) {
            addCriterion("check_number <>", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberGreaterThan(String value) {
            addCriterion("check_number >", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberGreaterThanOrEqualTo(String value) {
            addCriterion("check_number >=", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberLessThan(String value) {
            addCriterion("check_number <", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberLessThanOrEqualTo(String value) {
            addCriterion("check_number <=", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberLike(String value) {
            addCriterion("check_number like", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotLike(String value) {
            addCriterion("check_number not like", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIn(List<String> values) {
            addCriterion("check_number in", values, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotIn(List<String> values) {
            addCriterion("check_number not in", values, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberBetween(String value1, String value2) {
            addCriterion("check_number between", value1, value2, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotBetween(String value1, String value2) {
            addCriterion("check_number not between", value1, value2, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("check_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("check_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("check_result =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("check_result <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("check_result >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("check_result >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("check_result <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("check_result <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("check_result like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("check_result not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("check_result in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("check_result not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("check_result between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("check_result not between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckSituationIsNull() {
            addCriterion("check_situation is null");
            return (Criteria) this;
        }

        public Criteria andCheckSituationIsNotNull() {
            addCriterion("check_situation is not null");
            return (Criteria) this;
        }

        public Criteria andCheckSituationEqualTo(String value) {
            addCriterion("check_situation =", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationNotEqualTo(String value) {
            addCriterion("check_situation <>", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationGreaterThan(String value) {
            addCriterion("check_situation >", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationGreaterThanOrEqualTo(String value) {
            addCriterion("check_situation >=", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationLessThan(String value) {
            addCriterion("check_situation <", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationLessThanOrEqualTo(String value) {
            addCriterion("check_situation <=", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationLike(String value) {
            addCriterion("check_situation like", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationNotLike(String value) {
            addCriterion("check_situation not like", value, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationIn(List<String> values) {
            addCriterion("check_situation in", values, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationNotIn(List<String> values) {
            addCriterion("check_situation not in", values, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationBetween(String value1, String value2) {
            addCriterion("check_situation between", value1, value2, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckSituationNotBetween(String value1, String value2) {
            addCriterion("check_situation not between", value1, value2, "checkSituation");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(String value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(String value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(String value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(String value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(String value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(String value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLike(String value) {
            addCriterion("check_time like", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotLike(String value) {
            addCriterion("check_time not like", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<String> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<String> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(String value1, String value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(String value1, String value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIsNull() {
            addCriterion("check_unit is null");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIsNotNull() {
            addCriterion("check_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUnitEqualTo(String value) {
            addCriterion("check_unit =", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotEqualTo(String value) {
            addCriterion("check_unit <>", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitGreaterThan(String value) {
            addCriterion("check_unit >", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitGreaterThanOrEqualTo(String value) {
            addCriterion("check_unit >=", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLessThan(String value) {
            addCriterion("check_unit <", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLessThanOrEqualTo(String value) {
            addCriterion("check_unit <=", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitLike(String value) {
            addCriterion("check_unit like", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotLike(String value) {
            addCriterion("check_unit not like", value, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitIn(List<String> values) {
            addCriterion("check_unit in", values, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotIn(List<String> values) {
            addCriterion("check_unit not in", values, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitBetween(String value1, String value2) {
            addCriterion("check_unit between", value1, value2, "checkUnit");
            return (Criteria) this;
        }

        public Criteria andCheckUnitNotBetween(String value1, String value2) {
            addCriterion("check_unit not between", value1, value2, "checkUnit");
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

        public Criteria andImplementSituationIsNull() {
            addCriterion("implement_situation is null");
            return (Criteria) this;
        }

        public Criteria andImplementSituationIsNotNull() {
            addCriterion("implement_situation is not null");
            return (Criteria) this;
        }

        public Criteria andImplementSituationEqualTo(String value) {
            addCriterion("implement_situation =", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationNotEqualTo(String value) {
            addCriterion("implement_situation <>", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationGreaterThan(String value) {
            addCriterion("implement_situation >", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationGreaterThanOrEqualTo(String value) {
            addCriterion("implement_situation >=", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationLessThan(String value) {
            addCriterion("implement_situation <", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationLessThanOrEqualTo(String value) {
            addCriterion("implement_situation <=", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationLike(String value) {
            addCriterion("implement_situation like", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationNotLike(String value) {
            addCriterion("implement_situation not like", value, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationIn(List<String> values) {
            addCriterion("implement_situation in", values, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationNotIn(List<String> values) {
            addCriterion("implement_situation not in", values, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationBetween(String value1, String value2) {
            addCriterion("implement_situation between", value1, value2, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andImplementSituationNotBetween(String value1, String value2) {
            addCriterion("implement_situation not between", value1, value2, "implementSituation");
            return (Criteria) this;
        }

        public Criteria andRectifyDateIsNull() {
            addCriterion("rectify_date is null");
            return (Criteria) this;
        }

        public Criteria andRectifyDateIsNotNull() {
            addCriterion("rectify_date is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyDateEqualTo(String value) {
            addCriterion("rectify_date =", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateNotEqualTo(String value) {
            addCriterion("rectify_date <>", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateGreaterThan(String value) {
            addCriterion("rectify_date >", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_date >=", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateLessThan(String value) {
            addCriterion("rectify_date <", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateLessThanOrEqualTo(String value) {
            addCriterion("rectify_date <=", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateLike(String value) {
            addCriterion("rectify_date like", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateNotLike(String value) {
            addCriterion("rectify_date not like", value, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateIn(List<String> values) {
            addCriterion("rectify_date in", values, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateNotIn(List<String> values) {
            addCriterion("rectify_date not in", values, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateBetween(String value1, String value2) {
            addCriterion("rectify_date between", value1, value2, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyDateNotBetween(String value1, String value2) {
            addCriterion("rectify_date not between", value1, value2, "rectifyDate");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionIsNull() {
            addCriterion("rectify_opinion is null");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionIsNotNull() {
            addCriterion("rectify_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionEqualTo(String value) {
            addCriterion("rectify_opinion =", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionNotEqualTo(String value) {
            addCriterion("rectify_opinion <>", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionGreaterThan(String value) {
            addCriterion("rectify_opinion >", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_opinion >=", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionLessThan(String value) {
            addCriterion("rectify_opinion <", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionLessThanOrEqualTo(String value) {
            addCriterion("rectify_opinion <=", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionLike(String value) {
            addCriterion("rectify_opinion like", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionNotLike(String value) {
            addCriterion("rectify_opinion not like", value, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionIn(List<String> values) {
            addCriterion("rectify_opinion in", values, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionNotIn(List<String> values) {
            addCriterion("rectify_opinion not in", values, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionBetween(String value1, String value2) {
            addCriterion("rectify_opinion between", value1, value2, "rectifyOpinion");
            return (Criteria) this;
        }

        public Criteria andRectifyOpinionNotBetween(String value1, String value2) {
            addCriterion("rectify_opinion not between", value1, value2, "rectifyOpinion");
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