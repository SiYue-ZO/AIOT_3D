package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class FireControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FireControlExample() {
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

        public Criteria andFireCtlIdIsNull() {
            addCriterion("fire_ctl_id is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdIsNotNull() {
            addCriterion("fire_ctl_id is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdEqualTo(String value) {
            addCriterion("fire_ctl_id =", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdNotEqualTo(String value) {
            addCriterion("fire_ctl_id <>", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdGreaterThan(String value) {
            addCriterion("fire_ctl_id >", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_id >=", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdLessThan(String value) {
            addCriterion("fire_ctl_id <", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_id <=", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdLike(String value) {
            addCriterion("fire_ctl_id like", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdNotLike(String value) {
            addCriterion("fire_ctl_id not like", value, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdIn(List<String> values) {
            addCriterion("fire_ctl_id in", values, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdNotIn(List<String> values) {
            addCriterion("fire_ctl_id not in", values, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdBetween(String value1, String value2) {
            addCriterion("fire_ctl_id between", value1, value2, "fireCtlId");
            return (Criteria) this;
        }

        public Criteria andFireCtlIdNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_id not between", value1, value2, "fireCtlId");
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

        public Criteria andFireCtlNameIsNull() {
            addCriterion("fire_ctl_name is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameIsNotNull() {
            addCriterion("fire_ctl_name is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameEqualTo(String value) {
            addCriterion("fire_ctl_name =", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameNotEqualTo(String value) {
            addCriterion("fire_ctl_name <>", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameGreaterThan(String value) {
            addCriterion("fire_ctl_name >", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_name >=", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameLessThan(String value) {
            addCriterion("fire_ctl_name <", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_name <=", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameLike(String value) {
            addCriterion("fire_ctl_name like", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameNotLike(String value) {
            addCriterion("fire_ctl_name not like", value, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameIn(List<String> values) {
            addCriterion("fire_ctl_name in", values, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameNotIn(List<String> values) {
            addCriterion("fire_ctl_name not in", values, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameBetween(String value1, String value2) {
            addCriterion("fire_ctl_name between", value1, value2, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlNameNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_name not between", value1, value2, "fireCtlName");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeIsNull() {
            addCriterion("fire_ctl_type is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeIsNotNull() {
            addCriterion("fire_ctl_type is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeEqualTo(String value) {
            addCriterion("fire_ctl_type =", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeNotEqualTo(String value) {
            addCriterion("fire_ctl_type <>", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeGreaterThan(String value) {
            addCriterion("fire_ctl_type >", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_type >=", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeLessThan(String value) {
            addCriterion("fire_ctl_type <", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_type <=", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeLike(String value) {
            addCriterion("fire_ctl_type like", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeNotLike(String value) {
            addCriterion("fire_ctl_type not like", value, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeIn(List<String> values) {
            addCriterion("fire_ctl_type in", values, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeNotIn(List<String> values) {
            addCriterion("fire_ctl_type not in", values, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeBetween(String value1, String value2) {
            addCriterion("fire_ctl_type between", value1, value2, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlTypeNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_type not between", value1, value2, "fireCtlType");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonIsNull() {
            addCriterion("fire_ctl_person is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonIsNotNull() {
            addCriterion("fire_ctl_person is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonEqualTo(String value) {
            addCriterion("fire_ctl_person =", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonNotEqualTo(String value) {
            addCriterion("fire_ctl_person <>", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonGreaterThan(String value) {
            addCriterion("fire_ctl_person >", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_person >=", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonLessThan(String value) {
            addCriterion("fire_ctl_person <", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_person <=", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonLike(String value) {
            addCriterion("fire_ctl_person like", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonNotLike(String value) {
            addCriterion("fire_ctl_person not like", value, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonIn(List<String> values) {
            addCriterion("fire_ctl_person in", values, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonNotIn(List<String> values) {
            addCriterion("fire_ctl_person not in", values, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonBetween(String value1, String value2) {
            addCriterion("fire_ctl_person between", value1, value2, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlPersonNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_person not between", value1, value2, "fireCtlPerson");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelIsNull() {
            addCriterion("fire_ctl_tel is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelIsNotNull() {
            addCriterion("fire_ctl_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelEqualTo(String value) {
            addCriterion("fire_ctl_tel =", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelNotEqualTo(String value) {
            addCriterion("fire_ctl_tel <>", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelGreaterThan(String value) {
            addCriterion("fire_ctl_tel >", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_tel >=", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelLessThan(String value) {
            addCriterion("fire_ctl_tel <", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_tel <=", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelLike(String value) {
            addCriterion("fire_ctl_tel like", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelNotLike(String value) {
            addCriterion("fire_ctl_tel not like", value, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelIn(List<String> values) {
            addCriterion("fire_ctl_tel in", values, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelNotIn(List<String> values) {
            addCriterion("fire_ctl_tel not in", values, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelBetween(String value1, String value2) {
            addCriterion("fire_ctl_tel between", value1, value2, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlTelNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_tel not between", value1, value2, "fireCtlTel");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeIsNull() {
            addCriterion("fire_ctl_describe is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeIsNotNull() {
            addCriterion("fire_ctl_describe is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeEqualTo(String value) {
            addCriterion("fire_ctl_describe =", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeNotEqualTo(String value) {
            addCriterion("fire_ctl_describe <>", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeGreaterThan(String value) {
            addCriterion("fire_ctl_describe >", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_describe >=", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeLessThan(String value) {
            addCriterion("fire_ctl_describe <", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_describe <=", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeLike(String value) {
            addCriterion("fire_ctl_describe like", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeNotLike(String value) {
            addCriterion("fire_ctl_describe not like", value, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeIn(List<String> values) {
            addCriterion("fire_ctl_describe in", values, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeNotIn(List<String> values) {
            addCriterion("fire_ctl_describe not in", values, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeBetween(String value1, String value2) {
            addCriterion("fire_ctl_describe between", value1, value2, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlDescribeNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_describe not between", value1, value2, "fireCtlDescribe");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlIsNull() {
            addCriterion("fire_ctl_url is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlIsNotNull() {
            addCriterion("fire_ctl_url is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlEqualTo(String value) {
            addCriterion("fire_ctl_url =", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlNotEqualTo(String value) {
            addCriterion("fire_ctl_url <>", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlGreaterThan(String value) {
            addCriterion("fire_ctl_url >", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_url >=", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlLessThan(String value) {
            addCriterion("fire_ctl_url <", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_url <=", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlLike(String value) {
            addCriterion("fire_ctl_url like", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlNotLike(String value) {
            addCriterion("fire_ctl_url not like", value, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlIn(List<String> values) {
            addCriterion("fire_ctl_url in", values, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlNotIn(List<String> values) {
            addCriterion("fire_ctl_url not in", values, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlBetween(String value1, String value2) {
            addCriterion("fire_ctl_url between", value1, value2, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlUrlNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_url not between", value1, value2, "fireCtlUrl");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelIsNull() {
            addCriterion("fire_ctl_level is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelIsNotNull() {
            addCriterion("fire_ctl_level is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelEqualTo(String value) {
            addCriterion("fire_ctl_level =", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelNotEqualTo(String value) {
            addCriterion("fire_ctl_level <>", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelGreaterThan(String value) {
            addCriterion("fire_ctl_level >", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_level >=", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelLessThan(String value) {
            addCriterion("fire_ctl_level <", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_level <=", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelLike(String value) {
            addCriterion("fire_ctl_level like", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelNotLike(String value) {
            addCriterion("fire_ctl_level not like", value, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelIn(List<String> values) {
            addCriterion("fire_ctl_level in", values, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelNotIn(List<String> values) {
            addCriterion("fire_ctl_level not in", values, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelBetween(String value1, String value2) {
            addCriterion("fire_ctl_level between", value1, value2, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlLevelNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_level not between", value1, value2, "fireCtlLevel");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleIsNull() {
            addCriterion("fire_ctl_scale is null");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleIsNotNull() {
            addCriterion("fire_ctl_scale is not null");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleEqualTo(String value) {
            addCriterion("fire_ctl_scale =", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleNotEqualTo(String value) {
            addCriterion("fire_ctl_scale <>", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleGreaterThan(String value) {
            addCriterion("fire_ctl_scale >", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleGreaterThanOrEqualTo(String value) {
            addCriterion("fire_ctl_scale >=", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleLessThan(String value) {
            addCriterion("fire_ctl_scale <", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleLessThanOrEqualTo(String value) {
            addCriterion("fire_ctl_scale <=", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleLike(String value) {
            addCriterion("fire_ctl_scale like", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleNotLike(String value) {
            addCriterion("fire_ctl_scale not like", value, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleIn(List<String> values) {
            addCriterion("fire_ctl_scale in", values, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleNotIn(List<String> values) {
            addCriterion("fire_ctl_scale not in", values, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleBetween(String value1, String value2) {
            addCriterion("fire_ctl_scale between", value1, value2, "fireCtlScale");
            return (Criteria) this;
        }

        public Criteria andFireCtlScaleNotBetween(String value1, String value2) {
            addCriterion("fire_ctl_scale not between", value1, value2, "fireCtlScale");
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