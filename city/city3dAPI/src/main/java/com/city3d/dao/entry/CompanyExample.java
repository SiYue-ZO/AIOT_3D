package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(String value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(String value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(String value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(String value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(String value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLike(String value) {
            addCriterion("add_id like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotLike(String value) {
            addCriterion("add_id not like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<String> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<String> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(String value1, String value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(String value1, String value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNull() {
            addCriterion("approval_no is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNotNull() {
            addCriterion("approval_no is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoEqualTo(String value) {
            addCriterion("approval_no =", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotEqualTo(String value) {
            addCriterion("approval_no <>", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThan(String value) {
            addCriterion("approval_no >", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThanOrEqualTo(String value) {
            addCriterion("approval_no >=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThan(String value) {
            addCriterion("approval_no <", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThanOrEqualTo(String value) {
            addCriterion("approval_no <=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLike(String value) {
            addCriterion("approval_no like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotLike(String value) {
            addCriterion("approval_no not like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIn(List<String> values) {
            addCriterion("approval_no in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotIn(List<String> values) {
            addCriterion("approval_no not in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoBetween(String value1, String value2) {
            addCriterion("approval_no between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotBetween(String value1, String value2) {
            addCriterion("approval_no not between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andAutoFireIsNull() {
            addCriterion("auto_fire is null");
            return (Criteria) this;
        }

        public Criteria andAutoFireIsNotNull() {
            addCriterion("auto_fire is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFireEqualTo(String value) {
            addCriterion("auto_fire =", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireNotEqualTo(String value) {
            addCriterion("auto_fire <>", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireGreaterThan(String value) {
            addCriterion("auto_fire >", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireGreaterThanOrEqualTo(String value) {
            addCriterion("auto_fire >=", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireLessThan(String value) {
            addCriterion("auto_fire <", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireLessThanOrEqualTo(String value) {
            addCriterion("auto_fire <=", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireLike(String value) {
            addCriterion("auto_fire like", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireNotLike(String value) {
            addCriterion("auto_fire not like", value, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireIn(List<String> values) {
            addCriterion("auto_fire in", values, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireNotIn(List<String> values) {
            addCriterion("auto_fire not in", values, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireBetween(String value1, String value2) {
            addCriterion("auto_fire between", value1, value2, "autoFire");
            return (Criteria) this;
        }

        public Criteria andAutoFireNotBetween(String value1, String value2) {
            addCriterion("auto_fire not between", value1, value2, "autoFire");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightIsNull() {
            addCriterion("building_height is null");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightIsNotNull() {
            addCriterion("building_height is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightEqualTo(String value) {
            addCriterion("building_height =", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightNotEqualTo(String value) {
            addCriterion("building_height <>", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightGreaterThan(String value) {
            addCriterion("building_height >", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightGreaterThanOrEqualTo(String value) {
            addCriterion("building_height >=", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightLessThan(String value) {
            addCriterion("building_height <", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightLessThanOrEqualTo(String value) {
            addCriterion("building_height <=", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightLike(String value) {
            addCriterion("building_height like", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightNotLike(String value) {
            addCriterion("building_height not like", value, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightIn(List<String> values) {
            addCriterion("building_height in", values, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightNotIn(List<String> values) {
            addCriterion("building_height not in", values, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightBetween(String value1, String value2) {
            addCriterion("building_height between", value1, value2, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingHeightNotBetween(String value1, String value2) {
            addCriterion("building_height not between", value1, value2, "buildingHeight");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIsNull() {
            addCriterion("building_storey is null");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIsNotNull() {
            addCriterion("building_storey is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyEqualTo(String value) {
            addCriterion("building_storey =", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotEqualTo(String value) {
            addCriterion("building_storey <>", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyGreaterThan(String value) {
            addCriterion("building_storey >", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyGreaterThanOrEqualTo(String value) {
            addCriterion("building_storey >=", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyLessThan(String value) {
            addCriterion("building_storey <", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyLessThanOrEqualTo(String value) {
            addCriterion("building_storey <=", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyLike(String value) {
            addCriterion("building_storey like", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotLike(String value) {
            addCriterion("building_storey not like", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIn(List<String> values) {
            addCriterion("building_storey in", values, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotIn(List<String> values) {
            addCriterion("building_storey not in", values, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyBetween(String value1, String value2) {
            addCriterion("building_storey between", value1, value2, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotBetween(String value1, String value2) {
            addCriterion("building_storey not between", value1, value2, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyIsNull() {
            addCriterion("cancel_company is null");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyIsNotNull() {
            addCriterion("cancel_company is not null");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyEqualTo(String value) {
            addCriterion("cancel_company =", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyNotEqualTo(String value) {
            addCriterion("cancel_company <>", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyGreaterThan(String value) {
            addCriterion("cancel_company >", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_company >=", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyLessThan(String value) {
            addCriterion("cancel_company <", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyLessThanOrEqualTo(String value) {
            addCriterion("cancel_company <=", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyLike(String value) {
            addCriterion("cancel_company like", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyNotLike(String value) {
            addCriterion("cancel_company not like", value, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyIn(List<String> values) {
            addCriterion("cancel_company in", values, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyNotIn(List<String> values) {
            addCriterion("cancel_company not in", values, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyBetween(String value1, String value2) {
            addCriterion("cancel_company between", value1, value2, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelCompanyNotBetween(String value1, String value2) {
            addCriterion("cancel_company not between", value1, value2, "cancelCompany");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNull() {
            addCriterion("cancel_date is null");
            return (Criteria) this;
        }

        public Criteria andCancelDateIsNotNull() {
            addCriterion("cancel_date is not null");
            return (Criteria) this;
        }

        public Criteria andCancelDateEqualTo(String value) {
            addCriterion("cancel_date =", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotEqualTo(String value) {
            addCriterion("cancel_date <>", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThan(String value) {
            addCriterion("cancel_date >", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_date >=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThan(String value) {
            addCriterion("cancel_date <", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLessThanOrEqualTo(String value) {
            addCriterion("cancel_date <=", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateLike(String value) {
            addCriterion("cancel_date like", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotLike(String value) {
            addCriterion("cancel_date not like", value, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateIn(List<String> values) {
            addCriterion("cancel_date in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotIn(List<String> values) {
            addCriterion("cancel_date not in", values, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateBetween(String value1, String value2) {
            addCriterion("cancel_date between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelDateNotBetween(String value1, String value2) {
            addCriterion("cancel_date not between", value1, value2, "cancelDate");
            return (Criteria) this;
        }

        public Criteria andCancelMarkIsNull() {
            addCriterion("cancel_mark is null");
            return (Criteria) this;
        }

        public Criteria andCancelMarkIsNotNull() {
            addCriterion("cancel_mark is not null");
            return (Criteria) this;
        }

        public Criteria andCancelMarkEqualTo(String value) {
            addCriterion("cancel_mark =", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkNotEqualTo(String value) {
            addCriterion("cancel_mark <>", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkGreaterThan(String value) {
            addCriterion("cancel_mark >", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_mark >=", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkLessThan(String value) {
            addCriterion("cancel_mark <", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkLessThanOrEqualTo(String value) {
            addCriterion("cancel_mark <=", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkLike(String value) {
            addCriterion("cancel_mark like", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkNotLike(String value) {
            addCriterion("cancel_mark not like", value, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkIn(List<String> values) {
            addCriterion("cancel_mark in", values, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkNotIn(List<String> values) {
            addCriterion("cancel_mark not in", values, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkBetween(String value1, String value2) {
            addCriterion("cancel_mark between", value1, value2, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelMarkNotBetween(String value1, String value2) {
            addCriterion("cancel_mark not between", value1, value2, "cancelMark");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNull() {
            addCriterion("community is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNotNull() {
            addCriterion("community is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityEqualTo(String value) {
            addCriterion("community =", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotEqualTo(String value) {
            addCriterion("community <>", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThan(String value) {
            addCriterion("community >", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("community >=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThan(String value) {
            addCriterion("community <", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThanOrEqualTo(String value) {
            addCriterion("community <=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLike(String value) {
            addCriterion("community like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotLike(String value) {
            addCriterion("community not like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityIn(List<String> values) {
            addCriterion("community in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotIn(List<String> values) {
            addCriterion("community not in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityBetween(String value1, String value2) {
            addCriterion("community between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotBetween(String value1, String value2) {
            addCriterion("community not between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("company_type like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("company_type not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyUseIsNull() {
            addCriterion("company_use is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUseIsNotNull() {
            addCriterion("company_use is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUseEqualTo(String value) {
            addCriterion("company_use =", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseNotEqualTo(String value) {
            addCriterion("company_use <>", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseGreaterThan(String value) {
            addCriterion("company_use >", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseGreaterThanOrEqualTo(String value) {
            addCriterion("company_use >=", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseLessThan(String value) {
            addCriterion("company_use <", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseLessThanOrEqualTo(String value) {
            addCriterion("company_use <=", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseLike(String value) {
            addCriterion("company_use like", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseNotLike(String value) {
            addCriterion("company_use not like", value, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseIn(List<String> values) {
            addCriterion("company_use in", values, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseNotIn(List<String> values) {
            addCriterion("company_use not in", values, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseBetween(String value1, String value2) {
            addCriterion("company_use between", value1, value2, "companyUse");
            return (Criteria) this;
        }

        public Criteria andCompanyUseNotBetween(String value1, String value2) {
            addCriterion("company_use not between", value1, value2, "companyUse");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaIsNull() {
            addCriterion("construction_area is null");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaIsNotNull() {
            addCriterion("construction_area is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaEqualTo(String value) {
            addCriterion("construction_area =", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaNotEqualTo(String value) {
            addCriterion("construction_area <>", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaGreaterThan(String value) {
            addCriterion("construction_area >", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaGreaterThanOrEqualTo(String value) {
            addCriterion("construction_area >=", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaLessThan(String value) {
            addCriterion("construction_area <", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaLessThanOrEqualTo(String value) {
            addCriterion("construction_area <=", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaLike(String value) {
            addCriterion("construction_area like", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaNotLike(String value) {
            addCriterion("construction_area not like", value, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaIn(List<String> values) {
            addCriterion("construction_area in", values, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaNotIn(List<String> values) {
            addCriterion("construction_area not in", values, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaBetween(String value1, String value2) {
            addCriterion("construction_area between", value1, value2, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionAreaNotBetween(String value1, String value2) {
            addCriterion("construction_area not between", value1, value2, "constructionArea");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyIsNull() {
            addCriterion("construction_manager_company is null");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyIsNotNull() {
            addCriterion("construction_manager_company is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyEqualTo(String value) {
            addCriterion("construction_manager_company =", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyNotEqualTo(String value) {
            addCriterion("construction_manager_company <>", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyGreaterThan(String value) {
            addCriterion("construction_manager_company >", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("construction_manager_company >=", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyLessThan(String value) {
            addCriterion("construction_manager_company <", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyLessThanOrEqualTo(String value) {
            addCriterion("construction_manager_company <=", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyLike(String value) {
            addCriterion("construction_manager_company like", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyNotLike(String value) {
            addCriterion("construction_manager_company not like", value, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyIn(List<String> values) {
            addCriterion("construction_manager_company in", values, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyNotIn(List<String> values) {
            addCriterion("construction_manager_company not in", values, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyBetween(String value1, String value2) {
            addCriterion("construction_manager_company between", value1, value2, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andConstructionManagerCompanyNotBetween(String value1, String value2) {
            addCriterion("construction_manager_company not between", value1, value2, "constructionManagerCompany");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andCoverAreaIsNull() {
            addCriterion("cover_area is null");
            return (Criteria) this;
        }

        public Criteria andCoverAreaIsNotNull() {
            addCriterion("cover_area is not null");
            return (Criteria) this;
        }

        public Criteria andCoverAreaEqualTo(String value) {
            addCriterion("cover_area =", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaNotEqualTo(String value) {
            addCriterion("cover_area <>", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaGreaterThan(String value) {
            addCriterion("cover_area >", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaGreaterThanOrEqualTo(String value) {
            addCriterion("cover_area >=", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaLessThan(String value) {
            addCriterion("cover_area <", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaLessThanOrEqualTo(String value) {
            addCriterion("cover_area <=", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaLike(String value) {
            addCriterion("cover_area like", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaNotLike(String value) {
            addCriterion("cover_area not like", value, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaIn(List<String> values) {
            addCriterion("cover_area in", values, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaNotIn(List<String> values) {
            addCriterion("cover_area not in", values, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaBetween(String value1, String value2) {
            addCriterion("cover_area between", value1, value2, "coverArea");
            return (Criteria) this;
        }

        public Criteria andCoverAreaNotBetween(String value1, String value2) {
            addCriterion("cover_area not between", value1, value2, "coverArea");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureIsNull() {
            addCriterion("economic_nature is null");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureIsNotNull() {
            addCriterion("economic_nature is not null");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureEqualTo(String value) {
            addCriterion("economic_nature =", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureNotEqualTo(String value) {
            addCriterion("economic_nature <>", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureGreaterThan(String value) {
            addCriterion("economic_nature >", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureGreaterThanOrEqualTo(String value) {
            addCriterion("economic_nature >=", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureLessThan(String value) {
            addCriterion("economic_nature <", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureLessThanOrEqualTo(String value) {
            addCriterion("economic_nature <=", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureLike(String value) {
            addCriterion("economic_nature like", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureNotLike(String value) {
            addCriterion("economic_nature not like", value, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureIn(List<String> values) {
            addCriterion("economic_nature in", values, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureNotIn(List<String> values) {
            addCriterion("economic_nature not in", values, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureBetween(String value1, String value2) {
            addCriterion("economic_nature between", value1, value2, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEconomicNatureNotBetween(String value1, String value2) {
            addCriterion("economic_nature not between", value1, value2, "economicNature");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEngageCountIsNull() {
            addCriterion("engage_count is null");
            return (Criteria) this;
        }

        public Criteria andEngageCountIsNotNull() {
            addCriterion("engage_count is not null");
            return (Criteria) this;
        }

        public Criteria andEngageCountEqualTo(String value) {
            addCriterion("engage_count =", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountNotEqualTo(String value) {
            addCriterion("engage_count <>", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountGreaterThan(String value) {
            addCriterion("engage_count >", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountGreaterThanOrEqualTo(String value) {
            addCriterion("engage_count >=", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountLessThan(String value) {
            addCriterion("engage_count <", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountLessThanOrEqualTo(String value) {
            addCriterion("engage_count <=", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountLike(String value) {
            addCriterion("engage_count like", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountNotLike(String value) {
            addCriterion("engage_count not like", value, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountIn(List<String> values) {
            addCriterion("engage_count in", values, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountNotIn(List<String> values) {
            addCriterion("engage_count not in", values, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountBetween(String value1, String value2) {
            addCriterion("engage_count between", value1, value2, "engageCount");
            return (Criteria) this;
        }

        public Criteria andEngageCountNotBetween(String value1, String value2) {
            addCriterion("engage_count not between", value1, value2, "engageCount");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFireLevelIsNull() {
            addCriterion("fire_level is null");
            return (Criteria) this;
        }

        public Criteria andFireLevelIsNotNull() {
            addCriterion("fire_level is not null");
            return (Criteria) this;
        }

        public Criteria andFireLevelEqualTo(String value) {
            addCriterion("fire_level =", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelNotEqualTo(String value) {
            addCriterion("fire_level <>", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelGreaterThan(String value) {
            addCriterion("fire_level >", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelGreaterThanOrEqualTo(String value) {
            addCriterion("fire_level >=", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelLessThan(String value) {
            addCriterion("fire_level <", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelLessThanOrEqualTo(String value) {
            addCriterion("fire_level <=", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelLike(String value) {
            addCriterion("fire_level like", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelNotLike(String value) {
            addCriterion("fire_level not like", value, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelIn(List<String> values) {
            addCriterion("fire_level in", values, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelNotIn(List<String> values) {
            addCriterion("fire_level not in", values, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelBetween(String value1, String value2) {
            addCriterion("fire_level between", value1, value2, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireLevelNotBetween(String value1, String value2) {
            addCriterion("fire_level not between", value1, value2, "fireLevel");
            return (Criteria) this;
        }

        public Criteria andFireManagerIsNull() {
            addCriterion("fire_manager is null");
            return (Criteria) this;
        }

        public Criteria andFireManagerIsNotNull() {
            addCriterion("fire_manager is not null");
            return (Criteria) this;
        }

        public Criteria andFireManagerEqualTo(String value) {
            addCriterion("fire_manager =", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerNotEqualTo(String value) {
            addCriterion("fire_manager <>", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerGreaterThan(String value) {
            addCriterion("fire_manager >", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerGreaterThanOrEqualTo(String value) {
            addCriterion("fire_manager >=", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerLessThan(String value) {
            addCriterion("fire_manager <", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerLessThanOrEqualTo(String value) {
            addCriterion("fire_manager <=", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerLike(String value) {
            addCriterion("fire_manager like", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerNotLike(String value) {
            addCriterion("fire_manager not like", value, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerIn(List<String> values) {
            addCriterion("fire_manager in", values, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerNotIn(List<String> values) {
            addCriterion("fire_manager not in", values, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerBetween(String value1, String value2) {
            addCriterion("fire_manager between", value1, value2, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireManagerNotBetween(String value1, String value2) {
            addCriterion("fire_manager not between", value1, value2, "fireManager");
            return (Criteria) this;
        }

        public Criteria andFireMangeIsNull() {
            addCriterion("fire_mange is null");
            return (Criteria) this;
        }

        public Criteria andFireMangeIsNotNull() {
            addCriterion("fire_mange is not null");
            return (Criteria) this;
        }

        public Criteria andFireMangeEqualTo(String value) {
            addCriterion("fire_mange =", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeNotEqualTo(String value) {
            addCriterion("fire_mange <>", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeGreaterThan(String value) {
            addCriterion("fire_mange >", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeGreaterThanOrEqualTo(String value) {
            addCriterion("fire_mange >=", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeLessThan(String value) {
            addCriterion("fire_mange <", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeLessThanOrEqualTo(String value) {
            addCriterion("fire_mange <=", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeLike(String value) {
            addCriterion("fire_mange like", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeNotLike(String value) {
            addCriterion("fire_mange not like", value, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeIn(List<String> values) {
            addCriterion("fire_mange in", values, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeNotIn(List<String> values) {
            addCriterion("fire_mange not in", values, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeBetween(String value1, String value2) {
            addCriterion("fire_mange between", value1, value2, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFireMangeNotBetween(String value1, String value2) {
            addCriterion("fire_mange not between", value1, value2, "fireMange");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIsNull() {
            addCriterion("fixed_assets is null");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIsNotNull() {
            addCriterion("fixed_assets is not null");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsEqualTo(String value) {
            addCriterion("fixed_assets =", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotEqualTo(String value) {
            addCriterion("fixed_assets <>", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsGreaterThan(String value) {
            addCriterion("fixed_assets >", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_assets >=", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLessThan(String value) {
            addCriterion("fixed_assets <", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLessThanOrEqualTo(String value) {
            addCriterion("fixed_assets <=", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLike(String value) {
            addCriterion("fixed_assets like", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotLike(String value) {
            addCriterion("fixed_assets not like", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIn(List<String> values) {
            addCriterion("fixed_assets in", values, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotIn(List<String> values) {
            addCriterion("fixed_assets not in", values, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsBetween(String value1, String value2) {
            addCriterion("fixed_assets between", value1, value2, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotBetween(String value1, String value2) {
            addCriterion("fixed_assets not between", value1, value2, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoIsNull() {
            addCriterion("geometry_info is null");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoIsNotNull() {
            addCriterion("geometry_info is not null");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoEqualTo(String value) {
            addCriterion("geometry_info =", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoNotEqualTo(String value) {
            addCriterion("geometry_info <>", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoGreaterThan(String value) {
            addCriterion("geometry_info >", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoGreaterThanOrEqualTo(String value) {
            addCriterion("geometry_info >=", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoLessThan(String value) {
            addCriterion("geometry_info <", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoLessThanOrEqualTo(String value) {
            addCriterion("geometry_info <=", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoLike(String value) {
            addCriterion("geometry_info like", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoNotLike(String value) {
            addCriterion("geometry_info not like", value, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoIn(List<String> values) {
            addCriterion("geometry_info in", values, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoNotIn(List<String> values) {
            addCriterion("geometry_info not in", values, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoBetween(String value1, String value2) {
            addCriterion("geometry_info between", value1, value2, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andGeometryInfoNotBetween(String value1, String value2) {
            addCriterion("geometry_info not between", value1, value2, "geometryInfo");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andImageInfoIsNull() {
            addCriterion("image_info is null");
            return (Criteria) this;
        }

        public Criteria andImageInfoIsNotNull() {
            addCriterion("image_info is not null");
            return (Criteria) this;
        }

        public Criteria andImageInfoEqualTo(String value) {
            addCriterion("image_info =", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoNotEqualTo(String value) {
            addCriterion("image_info <>", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoGreaterThan(String value) {
            addCriterion("image_info >", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoGreaterThanOrEqualTo(String value) {
            addCriterion("image_info >=", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoLessThan(String value) {
            addCriterion("image_info <", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoLessThanOrEqualTo(String value) {
            addCriterion("image_info <=", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoLike(String value) {
            addCriterion("image_info like", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoNotLike(String value) {
            addCriterion("image_info not like", value, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoIn(List<String> values) {
            addCriterion("image_info in", values, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoNotIn(List<String> values) {
            addCriterion("image_info not in", values, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoBetween(String value1, String value2) {
            addCriterion("image_info between", value1, value2, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andImageInfoNotBetween(String value1, String value2) {
            addCriterion("image_info not between", value1, value2, "imageInfo");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNull() {
            addCriterion("industry_type is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("industry_type is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(String value) {
            addCriterion("industry_type =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(String value) {
            addCriterion("industry_type <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(String value) {
            addCriterion("industry_type >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_type >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(String value) {
            addCriterion("industry_type <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
            addCriterion("industry_type <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLike(String value) {
            addCriterion("industry_type like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotLike(String value) {
            addCriterion("industry_type not like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<String> values) {
            addCriterion("industry_type in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<String> values) {
            addCriterion("industry_type not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(String value1, String value2) {
            addCriterion("industry_type between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(String value1, String value2) {
            addCriterion("industry_type not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIsSaveIsNull() {
            addCriterion("is_save is null");
            return (Criteria) this;
        }

        public Criteria andIsSaveIsNotNull() {
            addCriterion("is_save is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaveEqualTo(String value) {
            addCriterion("is_save =", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveNotEqualTo(String value) {
            addCriterion("is_save <>", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveGreaterThan(String value) {
            addCriterion("is_save >", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveGreaterThanOrEqualTo(String value) {
            addCriterion("is_save >=", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveLessThan(String value) {
            addCriterion("is_save <", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveLessThanOrEqualTo(String value) {
            addCriterion("is_save <=", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveLike(String value) {
            addCriterion("is_save like", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveNotLike(String value) {
            addCriterion("is_save not like", value, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveIn(List<String> values) {
            addCriterion("is_save in", values, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveNotIn(List<String> values) {
            addCriterion("is_save not in", values, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveBetween(String value1, String value2) {
            addCriterion("is_save between", value1, value2, "isSave");
            return (Criteria) this;
        }

        public Criteria andIsSaveNotBetween(String value1, String value2) {
            addCriterion("is_save not between", value1, value2, "isSave");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLegalManIsNull() {
            addCriterion("legal_man is null");
            return (Criteria) this;
        }

        public Criteria andLegalManIsNotNull() {
            addCriterion("legal_man is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManEqualTo(String value) {
            addCriterion("legal_man =", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManNotEqualTo(String value) {
            addCriterion("legal_man <>", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManGreaterThan(String value) {
            addCriterion("legal_man >", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man >=", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManLessThan(String value) {
            addCriterion("legal_man <", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManLessThanOrEqualTo(String value) {
            addCriterion("legal_man <=", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManLike(String value) {
            addCriterion("legal_man like", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManNotLike(String value) {
            addCriterion("legal_man not like", value, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManIn(List<String> values) {
            addCriterion("legal_man in", values, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManNotIn(List<String> values) {
            addCriterion("legal_man not in", values, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManBetween(String value1, String value2) {
            addCriterion("legal_man between", value1, value2, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLegalManNotBetween(String value1, String value2) {
            addCriterion("legal_man not between", value1, value2, "legalMan");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateIsNull() {
            addCriterion("license_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateIsNotNull() {
            addCriterion("license_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateEqualTo(String value) {
            addCriterion("license_begin_date =", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateNotEqualTo(String value) {
            addCriterion("license_begin_date <>", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateGreaterThan(String value) {
            addCriterion("license_begin_date >", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("license_begin_date >=", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateLessThan(String value) {
            addCriterion("license_begin_date <", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateLessThanOrEqualTo(String value) {
            addCriterion("license_begin_date <=", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateLike(String value) {
            addCriterion("license_begin_date like", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateNotLike(String value) {
            addCriterion("license_begin_date not like", value, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateIn(List<String> values) {
            addCriterion("license_begin_date in", values, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateNotIn(List<String> values) {
            addCriterion("license_begin_date not in", values, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateBetween(String value1, String value2) {
            addCriterion("license_begin_date between", value1, value2, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseBeginDateNotBetween(String value1, String value2) {
            addCriterion("license_begin_date not between", value1, value2, "licenseBeginDate");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateIsNull() {
            addCriterion("license_send_date is null");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateIsNotNull() {
            addCriterion("license_send_date is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateEqualTo(String value) {
            addCriterion("license_send_date =", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateNotEqualTo(String value) {
            addCriterion("license_send_date <>", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateGreaterThan(String value) {
            addCriterion("license_send_date >", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateGreaterThanOrEqualTo(String value) {
            addCriterion("license_send_date >=", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateLessThan(String value) {
            addCriterion("license_send_date <", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateLessThanOrEqualTo(String value) {
            addCriterion("license_send_date <=", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateLike(String value) {
            addCriterion("license_send_date like", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateNotLike(String value) {
            addCriterion("license_send_date not like", value, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateIn(List<String> values) {
            addCriterion("license_send_date in", values, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateNotIn(List<String> values) {
            addCriterion("license_send_date not in", values, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateBetween(String value1, String value2) {
            addCriterion("license_send_date between", value1, value2, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andLicenseSendDateNotBetween(String value1, String value2) {
            addCriterion("license_send_date not between", value1, value2, "licenseSendDate");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIsNull() {
            addCriterion("main_business is null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIsNotNull() {
            addCriterion("main_business is not null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessEqualTo(String value) {
            addCriterion("main_business =", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotEqualTo(String value) {
            addCriterion("main_business <>", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessGreaterThan(String value) {
            addCriterion("main_business >", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("main_business >=", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLessThan(String value) {
            addCriterion("main_business <", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLessThanOrEqualTo(String value) {
            addCriterion("main_business <=", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLike(String value) {
            addCriterion("main_business like", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotLike(String value) {
            addCriterion("main_business not like", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIn(List<String> values) {
            addCriterion("main_business in", values, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotIn(List<String> values) {
            addCriterion("main_business not in", values, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessBetween(String value1, String value2) {
            addCriterion("main_business between", value1, value2, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotBetween(String value1, String value2) {
            addCriterion("main_business not between", value1, value2, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentIsNull() {
            addCriterion("main_manage_department is null");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentIsNotNull() {
            addCriterion("main_manage_department is not null");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentEqualTo(String value) {
            addCriterion("main_manage_department =", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotEqualTo(String value) {
            addCriterion("main_manage_department <>", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentGreaterThan(String value) {
            addCriterion("main_manage_department >", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("main_manage_department >=", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLessThan(String value) {
            addCriterion("main_manage_department <", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLessThanOrEqualTo(String value) {
            addCriterion("main_manage_department <=", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLike(String value) {
            addCriterion("main_manage_department like", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotLike(String value) {
            addCriterion("main_manage_department not like", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentIn(List<String> values) {
            addCriterion("main_manage_department in", values, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotIn(List<String> values) {
            addCriterion("main_manage_department not in", values, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentBetween(String value1, String value2) {
            addCriterion("main_manage_department between", value1, value2, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotBetween(String value1, String value2) {
            addCriterion("main_manage_department not between", value1, value2, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentIsNull() {
            addCriterion("manage_department is null");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentIsNotNull() {
            addCriterion("manage_department is not null");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentEqualTo(String value) {
            addCriterion("manage_department =", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentNotEqualTo(String value) {
            addCriterion("manage_department <>", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentGreaterThan(String value) {
            addCriterion("manage_department >", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("manage_department >=", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentLessThan(String value) {
            addCriterion("manage_department <", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentLessThanOrEqualTo(String value) {
            addCriterion("manage_department <=", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentLike(String value) {
            addCriterion("manage_department like", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentNotLike(String value) {
            addCriterion("manage_department not like", value, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentIn(List<String> values) {
            addCriterion("manage_department in", values, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentNotIn(List<String> values) {
            addCriterion("manage_department not in", values, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentBetween(String value1, String value2) {
            addCriterion("manage_department between", value1, value2, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageDepartmentNotBetween(String value1, String value2) {
            addCriterion("manage_department not between", value1, value2, "manageDepartment");
            return (Criteria) this;
        }

        public Criteria andManageTypeIsNull() {
            addCriterion("manage_type is null");
            return (Criteria) this;
        }

        public Criteria andManageTypeIsNotNull() {
            addCriterion("manage_type is not null");
            return (Criteria) this;
        }

        public Criteria andManageTypeEqualTo(String value) {
            addCriterion("manage_type =", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeNotEqualTo(String value) {
            addCriterion("manage_type <>", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeGreaterThan(String value) {
            addCriterion("manage_type >", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("manage_type >=", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeLessThan(String value) {
            addCriterion("manage_type <", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeLessThanOrEqualTo(String value) {
            addCriterion("manage_type <=", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeLike(String value) {
            addCriterion("manage_type like", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeNotLike(String value) {
            addCriterion("manage_type not like", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeIn(List<String> values) {
            addCriterion("manage_type in", values, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeNotIn(List<String> values) {
            addCriterion("manage_type not in", values, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeBetween(String value1, String value2) {
            addCriterion("manage_type between", value1, value2, "manageType");
            return (Criteria) this;
        }

        public Criteria andManageTypeNotBetween(String value1, String value2) {
            addCriterion("manage_type not between", value1, value2, "manageType");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityIsNull() {
            addCriterion("manager_identity is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityIsNotNull() {
            addCriterion("manager_identity is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityEqualTo(String value) {
            addCriterion("manager_identity =", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityNotEqualTo(String value) {
            addCriterion("manager_identity <>", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityGreaterThan(String value) {
            addCriterion("manager_identity >", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("manager_identity >=", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityLessThan(String value) {
            addCriterion("manager_identity <", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityLessThanOrEqualTo(String value) {
            addCriterion("manager_identity <=", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityLike(String value) {
            addCriterion("manager_identity like", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityNotLike(String value) {
            addCriterion("manager_identity not like", value, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityIn(List<String> values) {
            addCriterion("manager_identity in", values, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityNotIn(List<String> values) {
            addCriterion("manager_identity not in", values, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityBetween(String value1, String value2) {
            addCriterion("manager_identity between", value1, value2, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerIdentityNotBetween(String value1, String value2) {
            addCriterion("manager_identity not between", value1, value2, "managerIdentity");
            return (Criteria) this;
        }

        public Criteria andManagerTelIsNull() {
            addCriterion("manager_tel is null");
            return (Criteria) this;
        }

        public Criteria andManagerTelIsNotNull() {
            addCriterion("manager_tel is not null");
            return (Criteria) this;
        }

        public Criteria andManagerTelEqualTo(String value) {
            addCriterion("manager_tel =", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotEqualTo(String value) {
            addCriterion("manager_tel <>", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelGreaterThan(String value) {
            addCriterion("manager_tel >", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelGreaterThanOrEqualTo(String value) {
            addCriterion("manager_tel >=", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLessThan(String value) {
            addCriterion("manager_tel <", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLessThanOrEqualTo(String value) {
            addCriterion("manager_tel <=", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLike(String value) {
            addCriterion("manager_tel like", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotLike(String value) {
            addCriterion("manager_tel not like", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelIn(List<String> values) {
            addCriterion("manager_tel in", values, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotIn(List<String> values) {
            addCriterion("manager_tel not in", values, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelBetween(String value1, String value2) {
            addCriterion("manager_tel between", value1, value2, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotBetween(String value1, String value2) {
            addCriterion("manager_tel not between", value1, value2, "managerTel");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeIsNull() {
            addCriterion("nine_small_type is null");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeIsNotNull() {
            addCriterion("nine_small_type is not null");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeEqualTo(String value) {
            addCriterion("nine_small_type =", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeNotEqualTo(String value) {
            addCriterion("nine_small_type <>", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeGreaterThan(String value) {
            addCriterion("nine_small_type >", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeGreaterThanOrEqualTo(String value) {
            addCriterion("nine_small_type >=", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeLessThan(String value) {
            addCriterion("nine_small_type <", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeLessThanOrEqualTo(String value) {
            addCriterion("nine_small_type <=", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeLike(String value) {
            addCriterion("nine_small_type like", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeNotLike(String value) {
            addCriterion("nine_small_type not like", value, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeIn(List<String> values) {
            addCriterion("nine_small_type in", values, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeNotIn(List<String> values) {
            addCriterion("nine_small_type not in", values, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeBetween(String value1, String value2) {
            addCriterion("nine_small_type between", value1, value2, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andNineSmallTypeNotBetween(String value1, String value2) {
            addCriterion("nine_small_type not between", value1, value2, "nineSmallType");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(String value) {
            addCriterion("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(String value) {
            addCriterion("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(String value) {
            addCriterion("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(String value) {
            addCriterion("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(String value) {
            addCriterion("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(String value) {
            addCriterion("open_date <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLike(String value) {
            addCriterion("open_date like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotLike(String value) {
            addCriterion("open_date not like", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<String> values) {
            addCriterion("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<String> values) {
            addCriterion("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(String value1, String value2) {
            addCriterion("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(String value1, String value2) {
            addCriterion("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOperateModeIsNull() {
            addCriterion("operate_mode is null");
            return (Criteria) this;
        }

        public Criteria andOperateModeIsNotNull() {
            addCriterion("operate_mode is not null");
            return (Criteria) this;
        }

        public Criteria andOperateModeEqualTo(String value) {
            addCriterion("operate_mode =", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotEqualTo(String value) {
            addCriterion("operate_mode <>", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeGreaterThan(String value) {
            addCriterion("operate_mode >", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_mode >=", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeLessThan(String value) {
            addCriterion("operate_mode <", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeLessThanOrEqualTo(String value) {
            addCriterion("operate_mode <=", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeLike(String value) {
            addCriterion("operate_mode like", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotLike(String value) {
            addCriterion("operate_mode not like", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeIn(List<String> values) {
            addCriterion("operate_mode in", values, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotIn(List<String> values) {
            addCriterion("operate_mode not in", values, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeBetween(String value1, String value2) {
            addCriterion("operate_mode between", value1, value2, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotBetween(String value1, String value2) {
            addCriterion("operate_mode not between", value1, value2, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("organization is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("organization is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(String value) {
            addCriterion("organization =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(String value) {
            addCriterion("organization <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(String value) {
            addCriterion("organization >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("organization >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(String value) {
            addCriterion("organization <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(String value) {
            addCriterion("organization <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLike(String value) {
            addCriterion("organization like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotLike(String value) {
            addCriterion("organization not like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<String> values) {
            addCriterion("organization in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<String> values) {
            addCriterion("organization not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(String value1, String value2) {
            addCriterion("organization between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(String value1, String value2) {
            addCriterion("organization not between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andPostNoIsNull() {
            addCriterion("post_no is null");
            return (Criteria) this;
        }

        public Criteria andPostNoIsNotNull() {
            addCriterion("post_no is not null");
            return (Criteria) this;
        }

        public Criteria andPostNoEqualTo(String value) {
            addCriterion("post_no =", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotEqualTo(String value) {
            addCriterion("post_no <>", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoGreaterThan(String value) {
            addCriterion("post_no >", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoGreaterThanOrEqualTo(String value) {
            addCriterion("post_no >=", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLessThan(String value) {
            addCriterion("post_no <", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLessThanOrEqualTo(String value) {
            addCriterion("post_no <=", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLike(String value) {
            addCriterion("post_no like", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotLike(String value) {
            addCriterion("post_no not like", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoIn(List<String> values) {
            addCriterion("post_no in", values, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotIn(List<String> values) {
            addCriterion("post_no not in", values, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoBetween(String value1, String value2) {
            addCriterion("post_no between", value1, value2, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotBetween(String value1, String value2) {
            addCriterion("post_no not between", value1, value2, "postNo");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNull() {
            addCriterion("regist_address is null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNotNull() {
            addCriterion("regist_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressEqualTo(String value) {
            addCriterion("regist_address =", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotEqualTo(String value) {
            addCriterion("regist_address <>", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThan(String value) {
            addCriterion("regist_address >", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThanOrEqualTo(String value) {
            addCriterion("regist_address >=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThan(String value) {
            addCriterion("regist_address <", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThanOrEqualTo(String value) {
            addCriterion("regist_address <=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLike(String value) {
            addCriterion("regist_address like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotLike(String value) {
            addCriterion("regist_address not like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIn(List<String> values) {
            addCriterion("regist_address in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotIn(List<String> values) {
            addCriterion("regist_address not in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressBetween(String value1, String value2) {
            addCriterion("regist_address between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotBetween(String value1, String value2) {
            addCriterion("regist_address not between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNull() {
            addCriterion("regist_date is null");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNotNull() {
            addCriterion("regist_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegistDateEqualTo(String value) {
            addCriterion("regist_date =", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotEqualTo(String value) {
            addCriterion("regist_date <>", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThan(String value) {
            addCriterion("regist_date >", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThanOrEqualTo(String value) {
            addCriterion("regist_date >=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThan(String value) {
            addCriterion("regist_date <", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThanOrEqualTo(String value) {
            addCriterion("regist_date <=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLike(String value) {
            addCriterion("regist_date like", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotLike(String value) {
            addCriterion("regist_date not like", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateIn(List<String> values) {
            addCriterion("regist_date in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotIn(List<String> values) {
            addCriterion("regist_date not in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateBetween(String value1, String value2) {
            addCriterion("regist_date between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotBetween(String value1, String value2) {
            addCriterion("regist_date not between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIsNull() {
            addCriterion("regist_money is null");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIsNotNull() {
            addCriterion("regist_money is not null");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyEqualTo(String value) {
            addCriterion("regist_money =", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotEqualTo(String value) {
            addCriterion("regist_money <>", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyGreaterThan(String value) {
            addCriterion("regist_money >", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("regist_money >=", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLessThan(String value) {
            addCriterion("regist_money <", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLessThanOrEqualTo(String value) {
            addCriterion("regist_money <=", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLike(String value) {
            addCriterion("regist_money like", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotLike(String value) {
            addCriterion("regist_money not like", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIn(List<String> values) {
            addCriterion("regist_money in", values, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotIn(List<String> values) {
            addCriterion("regist_money not in", values, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyBetween(String value1, String value2) {
            addCriterion("regist_money between", value1, value2, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotBetween(String value1, String value2) {
            addCriterion("regist_money not between", value1, value2, "registMoney");
            return (Criteria) this;
        }

        public Criteria andSaveLevelIsNull() {
            addCriterion("save_level is null");
            return (Criteria) this;
        }

        public Criteria andSaveLevelIsNotNull() {
            addCriterion("save_level is not null");
            return (Criteria) this;
        }

        public Criteria andSaveLevelEqualTo(String value) {
            addCriterion("save_level =", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelNotEqualTo(String value) {
            addCriterion("save_level <>", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelGreaterThan(String value) {
            addCriterion("save_level >", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelGreaterThanOrEqualTo(String value) {
            addCriterion("save_level >=", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelLessThan(String value) {
            addCriterion("save_level <", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelLessThanOrEqualTo(String value) {
            addCriterion("save_level <=", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelLike(String value) {
            addCriterion("save_level like", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelNotLike(String value) {
            addCriterion("save_level not like", value, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelIn(List<String> values) {
            addCriterion("save_level in", values, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelNotIn(List<String> values) {
            addCriterion("save_level not in", values, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelBetween(String value1, String value2) {
            addCriterion("save_level between", value1, value2, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveLevelNotBetween(String value1, String value2) {
            addCriterion("save_level not between", value1, value2, "saveLevel");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityIsNull() {
            addCriterion("save_man_identity is null");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityIsNotNull() {
            addCriterion("save_man_identity is not null");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityEqualTo(String value) {
            addCriterion("save_man_identity =", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityNotEqualTo(String value) {
            addCriterion("save_man_identity <>", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityGreaterThan(String value) {
            addCriterion("save_man_identity >", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("save_man_identity >=", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityLessThan(String value) {
            addCriterion("save_man_identity <", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityLessThanOrEqualTo(String value) {
            addCriterion("save_man_identity <=", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityLike(String value) {
            addCriterion("save_man_identity like", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityNotLike(String value) {
            addCriterion("save_man_identity not like", value, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityIn(List<String> values) {
            addCriterion("save_man_identity in", values, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityNotIn(List<String> values) {
            addCriterion("save_man_identity not in", values, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityBetween(String value1, String value2) {
            addCriterion("save_man_identity between", value1, value2, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManIdentityNotBetween(String value1, String value2) {
            addCriterion("save_man_identity not between", value1, value2, "saveManIdentity");
            return (Criteria) this;
        }

        public Criteria andSaveManNameIsNull() {
            addCriterion("save_man_name is null");
            return (Criteria) this;
        }

        public Criteria andSaveManNameIsNotNull() {
            addCriterion("save_man_name is not null");
            return (Criteria) this;
        }

        public Criteria andSaveManNameEqualTo(String value) {
            addCriterion("save_man_name =", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameNotEqualTo(String value) {
            addCriterion("save_man_name <>", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameGreaterThan(String value) {
            addCriterion("save_man_name >", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameGreaterThanOrEqualTo(String value) {
            addCriterion("save_man_name >=", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameLessThan(String value) {
            addCriterion("save_man_name <", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameLessThanOrEqualTo(String value) {
            addCriterion("save_man_name <=", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameLike(String value) {
            addCriterion("save_man_name like", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameNotLike(String value) {
            addCriterion("save_man_name not like", value, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameIn(List<String> values) {
            addCriterion("save_man_name in", values, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameNotIn(List<String> values) {
            addCriterion("save_man_name not in", values, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameBetween(String value1, String value2) {
            addCriterion("save_man_name between", value1, value2, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManNameNotBetween(String value1, String value2) {
            addCriterion("save_man_name not between", value1, value2, "saveManName");
            return (Criteria) this;
        }

        public Criteria andSaveManTelIsNull() {
            addCriterion("save_man_tel is null");
            return (Criteria) this;
        }

        public Criteria andSaveManTelIsNotNull() {
            addCriterion("save_man_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSaveManTelEqualTo(String value) {
            addCriterion("save_man_tel =", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelNotEqualTo(String value) {
            addCriterion("save_man_tel <>", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelGreaterThan(String value) {
            addCriterion("save_man_tel >", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelGreaterThanOrEqualTo(String value) {
            addCriterion("save_man_tel >=", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelLessThan(String value) {
            addCriterion("save_man_tel <", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelLessThanOrEqualTo(String value) {
            addCriterion("save_man_tel <=", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelLike(String value) {
            addCriterion("save_man_tel like", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelNotLike(String value) {
            addCriterion("save_man_tel not like", value, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelIn(List<String> values) {
            addCriterion("save_man_tel in", values, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelNotIn(List<String> values) {
            addCriterion("save_man_tel not in", values, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelBetween(String value1, String value2) {
            addCriterion("save_man_tel between", value1, value2, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveManTelNotBetween(String value1, String value2) {
            addCriterion("save_man_tel not between", value1, value2, "saveManTel");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNull() {
            addCriterion("save_type is null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNotNull() {
            addCriterion("save_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeEqualTo(String value) {
            addCriterion("save_type =", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotEqualTo(String value) {
            addCriterion("save_type <>", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThan(String value) {
            addCriterion("save_type >", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("save_type >=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThan(String value) {
            addCriterion("save_type <", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThanOrEqualTo(String value) {
            addCriterion("save_type <=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLike(String value) {
            addCriterion("save_type like", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotLike(String value) {
            addCriterion("save_type not like", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIn(List<String> values) {
            addCriterion("save_type in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotIn(List<String> values) {
            addCriterion("save_type not in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeBetween(String value1, String value2) {
            addCriterion("save_type between", value1, value2, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotBetween(String value1, String value2) {
            addCriterion("save_type not between", value1, value2, "saveType");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessIsNull() {
            addCriterion("second_business is null");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessIsNotNull() {
            addCriterion("second_business is not null");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessEqualTo(String value) {
            addCriterion("second_business =", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessNotEqualTo(String value) {
            addCriterion("second_business <>", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessGreaterThan(String value) {
            addCriterion("second_business >", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("second_business >=", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessLessThan(String value) {
            addCriterion("second_business <", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessLessThanOrEqualTo(String value) {
            addCriterion("second_business <=", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessLike(String value) {
            addCriterion("second_business like", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessNotLike(String value) {
            addCriterion("second_business not like", value, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessIn(List<String> values) {
            addCriterion("second_business in", values, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessNotIn(List<String> values) {
            addCriterion("second_business not in", values, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessBetween(String value1, String value2) {
            addCriterion("second_business between", value1, value2, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSecondBusinessNotBetween(String value1, String value2) {
            addCriterion("second_business not between", value1, value2, "secondBusiness");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeIsNull() {
            addCriterion("supervise_company_type is null");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeIsNotNull() {
            addCriterion("supervise_company_type is not null");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeEqualTo(String value) {
            addCriterion("supervise_company_type =", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeNotEqualTo(String value) {
            addCriterion("supervise_company_type <>", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeGreaterThan(String value) {
            addCriterion("supervise_company_type >", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("supervise_company_type >=", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeLessThan(String value) {
            addCriterion("supervise_company_type <", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("supervise_company_type <=", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeLike(String value) {
            addCriterion("supervise_company_type like", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeNotLike(String value) {
            addCriterion("supervise_company_type not like", value, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeIn(List<String> values) {
            addCriterion("supervise_company_type in", values, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeNotIn(List<String> values) {
            addCriterion("supervise_company_type not in", values, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeBetween(String value1, String value2) {
            addCriterion("supervise_company_type between", value1, value2, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andSuperviseCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("supervise_company_type not between", value1, value2, "superviseCompanyType");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNull() {
            addCriterion("tax_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNotNull() {
            addCriterion("tax_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNoEqualTo(String value) {
            addCriterion("tax_no =", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotEqualTo(String value) {
            addCriterion("tax_no <>", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThan(String value) {
            addCriterion("tax_no >", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("tax_no >=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThan(String value) {
            addCriterion("tax_no <", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThanOrEqualTo(String value) {
            addCriterion("tax_no <=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLike(String value) {
            addCriterion("tax_no like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotLike(String value) {
            addCriterion("tax_no not like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoIn(List<String> values) {
            addCriterion("tax_no in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotIn(List<String> values) {
            addCriterion("tax_no not in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoBetween(String value1, String value2) {
            addCriterion("tax_no between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotBetween(String value1, String value2) {
            addCriterion("tax_no not between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyIsNull() {
            addCriterion("upper_company is null");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyIsNotNull() {
            addCriterion("upper_company is not null");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyEqualTo(String value) {
            addCriterion("upper_company =", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyNotEqualTo(String value) {
            addCriterion("upper_company <>", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyGreaterThan(String value) {
            addCriterion("upper_company >", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("upper_company >=", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyLessThan(String value) {
            addCriterion("upper_company <", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyLessThanOrEqualTo(String value) {
            addCriterion("upper_company <=", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyLike(String value) {
            addCriterion("upper_company like", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyNotLike(String value) {
            addCriterion("upper_company not like", value, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyIn(List<String> values) {
            addCriterion("upper_company in", values, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyNotIn(List<String> values) {
            addCriterion("upper_company not in", values, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyBetween(String value1, String value2) {
            addCriterion("upper_company between", value1, value2, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUpperCompanyNotBetween(String value1, String value2) {
            addCriterion("upper_company not between", value1, value2, "upperCompany");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNull() {
            addCriterion("use_name is null");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNotNull() {
            addCriterion("use_name is not null");
            return (Criteria) this;
        }

        public Criteria andUseNameEqualTo(String value) {
            addCriterion("use_name =", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotEqualTo(String value) {
            addCriterion("use_name <>", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThan(String value) {
            addCriterion("use_name >", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThanOrEqualTo(String value) {
            addCriterion("use_name >=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThan(String value) {
            addCriterion("use_name <", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThanOrEqualTo(String value) {
            addCriterion("use_name <=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLike(String value) {
            addCriterion("use_name like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotLike(String value) {
            addCriterion("use_name not like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameIn(List<String> values) {
            addCriterion("use_name in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotIn(List<String> values) {
            addCriterion("use_name not in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameBetween(String value1, String value2) {
            addCriterion("use_name between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotBetween(String value1, String value2) {
            addCriterion("use_name not between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseIsNull() {
            addCriterion("without_license is null");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseIsNotNull() {
            addCriterion("without_license is not null");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseEqualTo(String value) {
            addCriterion("without_license =", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseNotEqualTo(String value) {
            addCriterion("without_license <>", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseGreaterThan(String value) {
            addCriterion("without_license >", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("without_license >=", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseLessThan(String value) {
            addCriterion("without_license <", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseLessThanOrEqualTo(String value) {
            addCriterion("without_license <=", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseLike(String value) {
            addCriterion("without_license like", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseNotLike(String value) {
            addCriterion("without_license not like", value, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseIn(List<String> values) {
            addCriterion("without_license in", values, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseNotIn(List<String> values) {
            addCriterion("without_license not in", values, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseBetween(String value1, String value2) {
            addCriterion("without_license between", value1, value2, "withoutLicense");
            return (Criteria) this;
        }

        public Criteria andWithoutLicenseNotBetween(String value1, String value2) {
            addCriterion("without_license not between", value1, value2, "withoutLicense");
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