package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PoliceCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoliceCaseExample() {
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

        public Criteria andNetIdIsNull() {
            addCriterion("net_id is null");
            return (Criteria) this;
        }

        public Criteria andNetIdIsNotNull() {
            addCriterion("net_id is not null");
            return (Criteria) this;
        }

        public Criteria andNetIdEqualTo(String value) {
            addCriterion("net_id =", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotEqualTo(String value) {
            addCriterion("net_id <>", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThan(String value) {
            addCriterion("net_id >", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThanOrEqualTo(String value) {
            addCriterion("net_id >=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThan(String value) {
            addCriterion("net_id <", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThanOrEqualTo(String value) {
            addCriterion("net_id <=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLike(String value) {
            addCriterion("net_id like", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotLike(String value) {
            addCriterion("net_id not like", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdIn(List<String> values) {
            addCriterion("net_id in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotIn(List<String> values) {
            addCriterion("net_id not in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdBetween(String value1, String value2) {
            addCriterion("net_id between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotBetween(String value1, String value2) {
            addCriterion("net_id not between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNull() {
            addCriterion("case_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNotNull() {
            addCriterion("case_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNameEqualTo(String value) {
            addCriterion("case_name =", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotEqualTo(String value) {
            addCriterion("case_name <>", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThan(String value) {
            addCriterion("case_name >", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_name >=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThan(String value) {
            addCriterion("case_name <", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThanOrEqualTo(String value) {
            addCriterion("case_name <=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLike(String value) {
            addCriterion("case_name like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotLike(String value) {
            addCriterion("case_name not like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameIn(List<String> values) {
            addCriterion("case_name in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotIn(List<String> values) {
            addCriterion("case_name not in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameBetween(String value1, String value2) {
            addCriterion("case_name between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotBetween(String value1, String value2) {
            addCriterion("case_name not between", value1, value2, "caseName");
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

        public Criteria andCaseAddrIsNull() {
            addCriterion("case_addr is null");
            return (Criteria) this;
        }

        public Criteria andCaseAddrIsNotNull() {
            addCriterion("case_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAddrEqualTo(String value) {
            addCriterion("case_addr =", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrNotEqualTo(String value) {
            addCriterion("case_addr <>", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrGreaterThan(String value) {
            addCriterion("case_addr >", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("case_addr >=", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrLessThan(String value) {
            addCriterion("case_addr <", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrLessThanOrEqualTo(String value) {
            addCriterion("case_addr <=", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrLike(String value) {
            addCriterion("case_addr like", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrNotLike(String value) {
            addCriterion("case_addr not like", value, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrIn(List<String> values) {
            addCriterion("case_addr in", values, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrNotIn(List<String> values) {
            addCriterion("case_addr not in", values, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrBetween(String value1, String value2) {
            addCriterion("case_addr between", value1, value2, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCaseAddrNotBetween(String value1, String value2) {
            addCriterion("case_addr not between", value1, value2, "caseAddr");
            return (Criteria) this;
        }

        public Criteria andCasePositionIsNull() {
            addCriterion("case_position is null");
            return (Criteria) this;
        }

        public Criteria andCasePositionIsNotNull() {
            addCriterion("case_position is not null");
            return (Criteria) this;
        }

        public Criteria andCasePositionEqualTo(String value) {
            addCriterion("case_position =", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionNotEqualTo(String value) {
            addCriterion("case_position <>", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionGreaterThan(String value) {
            addCriterion("case_position >", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionGreaterThanOrEqualTo(String value) {
            addCriterion("case_position >=", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionLessThan(String value) {
            addCriterion("case_position <", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionLessThanOrEqualTo(String value) {
            addCriterion("case_position <=", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionLike(String value) {
            addCriterion("case_position like", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionNotLike(String value) {
            addCriterion("case_position not like", value, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionIn(List<String> values) {
            addCriterion("case_position in", values, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionNotIn(List<String> values) {
            addCriterion("case_position not in", values, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionBetween(String value1, String value2) {
            addCriterion("case_position between", value1, value2, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCasePositionNotBetween(String value1, String value2) {
            addCriterion("case_position not between", value1, value2, "casePosition");
            return (Criteria) this;
        }

        public Criteria andCaseDateIsNull() {
            addCriterion("case_date is null");
            return (Criteria) this;
        }

        public Criteria andCaseDateIsNotNull() {
            addCriterion("case_date is not null");
            return (Criteria) this;
        }

        public Criteria andCaseDateEqualTo(String value) {
            addCriterion("case_date =", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateNotEqualTo(String value) {
            addCriterion("case_date <>", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateGreaterThan(String value) {
            addCriterion("case_date >", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateGreaterThanOrEqualTo(String value) {
            addCriterion("case_date >=", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateLessThan(String value) {
            addCriterion("case_date <", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateLessThanOrEqualTo(String value) {
            addCriterion("case_date <=", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateLike(String value) {
            addCriterion("case_date like", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateNotLike(String value) {
            addCriterion("case_date not like", value, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateIn(List<String> values) {
            addCriterion("case_date in", values, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateNotIn(List<String> values) {
            addCriterion("case_date not in", values, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateBetween(String value1, String value2) {
            addCriterion("case_date between", value1, value2, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseDateNotBetween(String value1, String value2) {
            addCriterion("case_date not between", value1, value2, "caseDate");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIsNull() {
            addCriterion("case_source is null");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIsNotNull() {
            addCriterion("case_source is not null");
            return (Criteria) this;
        }

        public Criteria andCaseSourceEqualTo(String value) {
            addCriterion("case_source =", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotEqualTo(String value) {
            addCriterion("case_source <>", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceGreaterThan(String value) {
            addCriterion("case_source >", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceGreaterThanOrEqualTo(String value) {
            addCriterion("case_source >=", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLessThan(String value) {
            addCriterion("case_source <", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLessThanOrEqualTo(String value) {
            addCriterion("case_source <=", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLike(String value) {
            addCriterion("case_source like", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotLike(String value) {
            addCriterion("case_source not like", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIn(List<String> values) {
            addCriterion("case_source in", values, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotIn(List<String> values) {
            addCriterion("case_source not in", values, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceBetween(String value1, String value2) {
            addCriterion("case_source between", value1, value2, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotBetween(String value1, String value2) {
            addCriterion("case_source not between", value1, value2, "caseSource");
            return (Criteria) this;
        }

        public Criteria andVictimIsNull() {
            addCriterion("victim is null");
            return (Criteria) this;
        }

        public Criteria andVictimIsNotNull() {
            addCriterion("victim is not null");
            return (Criteria) this;
        }

        public Criteria andVictimEqualTo(String value) {
            addCriterion("victim =", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimNotEqualTo(String value) {
            addCriterion("victim <>", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimGreaterThan(String value) {
            addCriterion("victim >", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimGreaterThanOrEqualTo(String value) {
            addCriterion("victim >=", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimLessThan(String value) {
            addCriterion("victim <", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimLessThanOrEqualTo(String value) {
            addCriterion("victim <=", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimLike(String value) {
            addCriterion("victim like", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimNotLike(String value) {
            addCriterion("victim not like", value, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimIn(List<String> values) {
            addCriterion("victim in", values, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimNotIn(List<String> values) {
            addCriterion("victim not in", values, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimBetween(String value1, String value2) {
            addCriterion("victim between", value1, value2, "victim");
            return (Criteria) this;
        }

        public Criteria andVictimNotBetween(String value1, String value2) {
            addCriterion("victim not between", value1, value2, "victim");
            return (Criteria) this;
        }

        public Criteria andSuspectIsNull() {
            addCriterion("suspect is null");
            return (Criteria) this;
        }

        public Criteria andSuspectIsNotNull() {
            addCriterion("suspect is not null");
            return (Criteria) this;
        }

        public Criteria andSuspectEqualTo(String value) {
            addCriterion("suspect =", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotEqualTo(String value) {
            addCriterion("suspect <>", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectGreaterThan(String value) {
            addCriterion("suspect >", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectGreaterThanOrEqualTo(String value) {
            addCriterion("suspect >=", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectLessThan(String value) {
            addCriterion("suspect <", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectLessThanOrEqualTo(String value) {
            addCriterion("suspect <=", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectLike(String value) {
            addCriterion("suspect like", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotLike(String value) {
            addCriterion("suspect not like", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectIn(List<String> values) {
            addCriterion("suspect in", values, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotIn(List<String> values) {
            addCriterion("suspect not in", values, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectBetween(String value1, String value2) {
            addCriterion("suspect between", value1, value2, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotBetween(String value1, String value2) {
            addCriterion("suspect not between", value1, value2, "suspect");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeIsNull() {
            addCriterion("case_describe is null");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeIsNotNull() {
            addCriterion("case_describe is not null");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeEqualTo(String value) {
            addCriterion("case_describe =", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeNotEqualTo(String value) {
            addCriterion("case_describe <>", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeGreaterThan(String value) {
            addCriterion("case_describe >", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("case_describe >=", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeLessThan(String value) {
            addCriterion("case_describe <", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeLessThanOrEqualTo(String value) {
            addCriterion("case_describe <=", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeLike(String value) {
            addCriterion("case_describe like", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeNotLike(String value) {
            addCriterion("case_describe not like", value, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeIn(List<String> values) {
            addCriterion("case_describe in", values, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeNotIn(List<String> values) {
            addCriterion("case_describe not in", values, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeBetween(String value1, String value2) {
            addCriterion("case_describe between", value1, value2, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andCaseDescribeNotBetween(String value1, String value2) {
            addCriterion("case_describe not between", value1, value2, "caseDescribe");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIsNull() {
            addCriterion("audio_url is null");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIsNotNull() {
            addCriterion("audio_url is not null");
            return (Criteria) this;
        }

        public Criteria andAudioUrlEqualTo(String value) {
            addCriterion("audio_url =", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotEqualTo(String value) {
            addCriterion("audio_url <>", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlGreaterThan(String value) {
            addCriterion("audio_url >", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlGreaterThanOrEqualTo(String value) {
            addCriterion("audio_url >=", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLessThan(String value) {
            addCriterion("audio_url <", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLessThanOrEqualTo(String value) {
            addCriterion("audio_url <=", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLike(String value) {
            addCriterion("audio_url like", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotLike(String value) {
            addCriterion("audio_url not like", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIn(List<String> values) {
            addCriterion("audio_url in", values, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotIn(List<String> values) {
            addCriterion("audio_url not in", values, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlBetween(String value1, String value2) {
            addCriterion("audio_url between", value1, value2, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotBetween(String value1, String value2) {
            addCriterion("audio_url not between", value1, value2, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andCaseResultIsNull() {
            addCriterion("case_result is null");
            return (Criteria) this;
        }

        public Criteria andCaseResultIsNotNull() {
            addCriterion("case_result is not null");
            return (Criteria) this;
        }

        public Criteria andCaseResultEqualTo(String value) {
            addCriterion("case_result =", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultNotEqualTo(String value) {
            addCriterion("case_result <>", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultGreaterThan(String value) {
            addCriterion("case_result >", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultGreaterThanOrEqualTo(String value) {
            addCriterion("case_result >=", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultLessThan(String value) {
            addCriterion("case_result <", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultLessThanOrEqualTo(String value) {
            addCriterion("case_result <=", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultLike(String value) {
            addCriterion("case_result like", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultNotLike(String value) {
            addCriterion("case_result not like", value, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultIn(List<String> values) {
            addCriterion("case_result in", values, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultNotIn(List<String> values) {
            addCriterion("case_result not in", values, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultBetween(String value1, String value2) {
            addCriterion("case_result between", value1, value2, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCaseResultNotBetween(String value1, String value2) {
            addCriterion("case_result not between", value1, value2, "caseResult");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNull() {
            addCriterion("cam_poi is null");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNotNull() {
            addCriterion("cam_poi is not null");
            return (Criteria) this;
        }

        public Criteria andCamPoiEqualTo(String value) {
            addCriterion("cam_poi =", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotEqualTo(String value) {
            addCriterion("cam_poi <>", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThan(String value) {
            addCriterion("cam_poi >", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThanOrEqualTo(String value) {
            addCriterion("cam_poi >=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThan(String value) {
            addCriterion("cam_poi <", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThanOrEqualTo(String value) {
            addCriterion("cam_poi <=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLike(String value) {
            addCriterion("cam_poi like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotLike(String value) {
            addCriterion("cam_poi not like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIn(List<String> values) {
            addCriterion("cam_poi in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotIn(List<String> values) {
            addCriterion("cam_poi not in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiBetween(String value1, String value2) {
            addCriterion("cam_poi between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotBetween(String value1, String value2) {
            addCriterion("cam_poi not between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNull() {
            addCriterion("cam_heading is null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNotNull() {
            addCriterion("cam_heading is not null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingEqualTo(String value) {
            addCriterion("cam_heading =", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotEqualTo(String value) {
            addCriterion("cam_heading <>", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThan(String value) {
            addCriterion("cam_heading >", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("cam_heading >=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThan(String value) {
            addCriterion("cam_heading <", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThanOrEqualTo(String value) {
            addCriterion("cam_heading <=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLike(String value) {
            addCriterion("cam_heading like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotLike(String value) {
            addCriterion("cam_heading not like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIn(List<String> values) {
            addCriterion("cam_heading in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotIn(List<String> values) {
            addCriterion("cam_heading not in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingBetween(String value1, String value2) {
            addCriterion("cam_heading between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotBetween(String value1, String value2) {
            addCriterion("cam_heading not between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNull() {
            addCriterion("cam_pitch is null");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNotNull() {
            addCriterion("cam_pitch is not null");
            return (Criteria) this;
        }

        public Criteria andCamPitchEqualTo(String value) {
            addCriterion("cam_pitch =", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotEqualTo(String value) {
            addCriterion("cam_pitch <>", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThan(String value) {
            addCriterion("cam_pitch >", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pitch >=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThan(String value) {
            addCriterion("cam_pitch <", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThanOrEqualTo(String value) {
            addCriterion("cam_pitch <=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLike(String value) {
            addCriterion("cam_pitch like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotLike(String value) {
            addCriterion("cam_pitch not like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchIn(List<String> values) {
            addCriterion("cam_pitch in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotIn(List<String> values) {
            addCriterion("cam_pitch not in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchBetween(String value1, String value2) {
            addCriterion("cam_pitch between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotBetween(String value1, String value2) {
            addCriterion("cam_pitch not between", value1, value2, "camPitch");
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