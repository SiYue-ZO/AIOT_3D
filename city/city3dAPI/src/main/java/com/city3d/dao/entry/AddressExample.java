package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddNameIsNull() {
            addCriterion("add_name is null");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNotNull() {
            addCriterion("add_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddNameEqualTo(String value) {
            addCriterion("add_name =", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotEqualTo(String value) {
            addCriterion("add_name <>", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThan(String value) {
            addCriterion("add_name >", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_name >=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThan(String value) {
            addCriterion("add_name <", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThanOrEqualTo(String value) {
            addCriterion("add_name <=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLike(String value) {
            addCriterion("add_name like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotLike(String value) {
            addCriterion("add_name not like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameIn(List<String> values) {
            addCriterion("add_name in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotIn(List<String> values) {
            addCriterion("add_name not in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameBetween(String value1, String value2) {
            addCriterion("add_name between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotBetween(String value1, String value2) {
            addCriterion("add_name not between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andSubdistrictIsNull() {
            addCriterion("subdistrict is null");
            return (Criteria) this;
        }

        public Criteria andSubdistrictIsNotNull() {
            addCriterion("subdistrict is not null");
            return (Criteria) this;
        }

        public Criteria andSubdistrictEqualTo(String value) {
            addCriterion("subdistrict =", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictNotEqualTo(String value) {
            addCriterion("subdistrict <>", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictGreaterThan(String value) {
            addCriterion("subdistrict >", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictGreaterThanOrEqualTo(String value) {
            addCriterion("subdistrict >=", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictLessThan(String value) {
            addCriterion("subdistrict <", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictLessThanOrEqualTo(String value) {
            addCriterion("subdistrict <=", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictLike(String value) {
            addCriterion("subdistrict like", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictNotLike(String value) {
            addCriterion("subdistrict not like", value, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictIn(List<String> values) {
            addCriterion("subdistrict in", values, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictNotIn(List<String> values) {
            addCriterion("subdistrict not in", values, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictBetween(String value1, String value2) {
            addCriterion("subdistrict between", value1, value2, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andSubdistrictNotBetween(String value1, String value2) {
            addCriterion("subdistrict not between", value1, value2, "subdistrict");
            return (Criteria) this;
        }

        public Criteria andCommunitiesIsNull() {
            addCriterion("communities is null");
            return (Criteria) this;
        }

        public Criteria andCommunitiesIsNotNull() {
            addCriterion("communities is not null");
            return (Criteria) this;
        }

        public Criteria andCommunitiesEqualTo(String value) {
            addCriterion("communities =", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesNotEqualTo(String value) {
            addCriterion("communities <>", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesGreaterThan(String value) {
            addCriterion("communities >", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesGreaterThanOrEqualTo(String value) {
            addCriterion("communities >=", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesLessThan(String value) {
            addCriterion("communities <", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesLessThanOrEqualTo(String value) {
            addCriterion("communities <=", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesLike(String value) {
            addCriterion("communities like", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesNotLike(String value) {
            addCriterion("communities not like", value, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesIn(List<String> values) {
            addCriterion("communities in", values, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesNotIn(List<String> values) {
            addCriterion("communities not in", values, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesBetween(String value1, String value2) {
            addCriterion("communities between", value1, value2, "communities");
            return (Criteria) this;
        }

        public Criteria andCommunitiesNotBetween(String value1, String value2) {
            addCriterion("communities not between", value1, value2, "communities");
            return (Criteria) this;
        }

        public Criteria andStreetIsNull() {
            addCriterion("street is null");
            return (Criteria) this;
        }

        public Criteria andStreetIsNotNull() {
            addCriterion("street is not null");
            return (Criteria) this;
        }

        public Criteria andStreetEqualTo(String value) {
            addCriterion("street =", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotEqualTo(String value) {
            addCriterion("street <>", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThan(String value) {
            addCriterion("street >", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThanOrEqualTo(String value) {
            addCriterion("street >=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThan(String value) {
            addCriterion("street <", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThanOrEqualTo(String value) {
            addCriterion("street <=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLike(String value) {
            addCriterion("street like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotLike(String value) {
            addCriterion("street not like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetIn(List<String> values) {
            addCriterion("street in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotIn(List<String> values) {
            addCriterion("street not in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetBetween(String value1, String value2) {
            addCriterion("street between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotBetween(String value1, String value2) {
            addCriterion("street not between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixIsNull() {
            addCriterion("house_num_prefix is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixIsNotNull() {
            addCriterion("house_num_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixEqualTo(String value) {
            addCriterion("house_num_prefix =", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixNotEqualTo(String value) {
            addCriterion("house_num_prefix <>", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixGreaterThan(String value) {
            addCriterion("house_num_prefix >", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("house_num_prefix >=", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixLessThan(String value) {
            addCriterion("house_num_prefix <", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixLessThanOrEqualTo(String value) {
            addCriterion("house_num_prefix <=", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixLike(String value) {
            addCriterion("house_num_prefix like", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixNotLike(String value) {
            addCriterion("house_num_prefix not like", value, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixIn(List<String> values) {
            addCriterion("house_num_prefix in", values, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixNotIn(List<String> values) {
            addCriterion("house_num_prefix not in", values, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixBetween(String value1, String value2) {
            addCriterion("house_num_prefix between", value1, value2, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPrefixNotBetween(String value1, String value2) {
            addCriterion("house_num_prefix not between", value1, value2, "houseNumPrefix");
            return (Criteria) this;
        }

        public Criteria andHouseNumIsNull() {
            addCriterion("house_num is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumIsNotNull() {
            addCriterion("house_num is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumEqualTo(String value) {
            addCriterion("house_num =", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotEqualTo(String value) {
            addCriterion("house_num <>", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumGreaterThan(String value) {
            addCriterion("house_num >", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumGreaterThanOrEqualTo(String value) {
            addCriterion("house_num >=", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLessThan(String value) {
            addCriterion("house_num <", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLessThanOrEqualTo(String value) {
            addCriterion("house_num <=", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumLike(String value) {
            addCriterion("house_num like", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotLike(String value) {
            addCriterion("house_num not like", value, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumIn(List<String> values) {
            addCriterion("house_num in", values, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotIn(List<String> values) {
            addCriterion("house_num not in", values, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumBetween(String value1, String value2) {
            addCriterion("house_num between", value1, value2, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumNotBetween(String value1, String value2) {
            addCriterion("house_num not between", value1, value2, "houseNum");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixIsNull() {
            addCriterion("house_num_postfix is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixIsNotNull() {
            addCriterion("house_num_postfix is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixEqualTo(String value) {
            addCriterion("house_num_postfix =", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixNotEqualTo(String value) {
            addCriterion("house_num_postfix <>", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixGreaterThan(String value) {
            addCriterion("house_num_postfix >", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixGreaterThanOrEqualTo(String value) {
            addCriterion("house_num_postfix >=", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixLessThan(String value) {
            addCriterion("house_num_postfix <", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixLessThanOrEqualTo(String value) {
            addCriterion("house_num_postfix <=", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixLike(String value) {
            addCriterion("house_num_postfix like", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixNotLike(String value) {
            addCriterion("house_num_postfix not like", value, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixIn(List<String> values) {
            addCriterion("house_num_postfix in", values, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixNotIn(List<String> values) {
            addCriterion("house_num_postfix not in", values, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixBetween(String value1, String value2) {
            addCriterion("house_num_postfix between", value1, value2, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andHouseNumPostfixNotBetween(String value1, String value2) {
            addCriterion("house_num_postfix not between", value1, value2, "houseNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumIsNull() {
            addCriterion("auxiliary_num is null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumIsNotNull() {
            addCriterion("auxiliary_num is not null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumEqualTo(String value) {
            addCriterion("auxiliary_num =", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumNotEqualTo(String value) {
            addCriterion("auxiliary_num <>", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumGreaterThan(String value) {
            addCriterion("auxiliary_num >", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumGreaterThanOrEqualTo(String value) {
            addCriterion("auxiliary_num >=", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumLessThan(String value) {
            addCriterion("auxiliary_num <", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumLessThanOrEqualTo(String value) {
            addCriterion("auxiliary_num <=", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumLike(String value) {
            addCriterion("auxiliary_num like", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumNotLike(String value) {
            addCriterion("auxiliary_num not like", value, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumIn(List<String> values) {
            addCriterion("auxiliary_num in", values, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumNotIn(List<String> values) {
            addCriterion("auxiliary_num not in", values, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumBetween(String value1, String value2) {
            addCriterion("auxiliary_num between", value1, value2, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumNotBetween(String value1, String value2) {
            addCriterion("auxiliary_num not between", value1, value2, "auxiliaryNum");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixIsNull() {
            addCriterion("auxiliary_num_postfix is null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixIsNotNull() {
            addCriterion("auxiliary_num_postfix is not null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixEqualTo(String value) {
            addCriterion("auxiliary_num_postfix =", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixNotEqualTo(String value) {
            addCriterion("auxiliary_num_postfix <>", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixGreaterThan(String value) {
            addCriterion("auxiliary_num_postfix >", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixGreaterThanOrEqualTo(String value) {
            addCriterion("auxiliary_num_postfix >=", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixLessThan(String value) {
            addCriterion("auxiliary_num_postfix <", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixLessThanOrEqualTo(String value) {
            addCriterion("auxiliary_num_postfix <=", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixLike(String value) {
            addCriterion("auxiliary_num_postfix like", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixNotLike(String value) {
            addCriterion("auxiliary_num_postfix not like", value, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixIn(List<String> values) {
            addCriterion("auxiliary_num_postfix in", values, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixNotIn(List<String> values) {
            addCriterion("auxiliary_num_postfix not in", values, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixBetween(String value1, String value2) {
            addCriterion("auxiliary_num_postfix between", value1, value2, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryNumPostfixNotBetween(String value1, String value2) {
            addCriterion("auxiliary_num_postfix not between", value1, value2, "auxiliaryNumPostfix");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixIsNull() {
            addCriterion("building_num_prefix is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixIsNotNull() {
            addCriterion("building_num_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixEqualTo(String value) {
            addCriterion("building_num_prefix =", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixNotEqualTo(String value) {
            addCriterion("building_num_prefix <>", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixGreaterThan(String value) {
            addCriterion("building_num_prefix >", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("building_num_prefix >=", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixLessThan(String value) {
            addCriterion("building_num_prefix <", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixLessThanOrEqualTo(String value) {
            addCriterion("building_num_prefix <=", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixLike(String value) {
            addCriterion("building_num_prefix like", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixNotLike(String value) {
            addCriterion("building_num_prefix not like", value, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixIn(List<String> values) {
            addCriterion("building_num_prefix in", values, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixNotIn(List<String> values) {
            addCriterion("building_num_prefix not in", values, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixBetween(String value1, String value2) {
            addCriterion("building_num_prefix between", value1, value2, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPrefixNotBetween(String value1, String value2) {
            addCriterion("building_num_prefix not between", value1, value2, "buildingNumPrefix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIsNull() {
            addCriterion("building_num is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIsNotNull() {
            addCriterion("building_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumEqualTo(String value) {
            addCriterion("building_num =", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotEqualTo(String value) {
            addCriterion("building_num <>", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumGreaterThan(String value) {
            addCriterion("building_num >", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumGreaterThanOrEqualTo(String value) {
            addCriterion("building_num >=", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumLessThan(String value) {
            addCriterion("building_num <", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumLessThanOrEqualTo(String value) {
            addCriterion("building_num <=", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumLike(String value) {
            addCriterion("building_num like", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotLike(String value) {
            addCriterion("building_num not like", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIn(List<String> values) {
            addCriterion("building_num in", values, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotIn(List<String> values) {
            addCriterion("building_num not in", values, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumBetween(String value1, String value2) {
            addCriterion("building_num between", value1, value2, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotBetween(String value1, String value2) {
            addCriterion("building_num not between", value1, value2, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixIsNull() {
            addCriterion("building_num_postfix is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixIsNotNull() {
            addCriterion("building_num_postfix is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixEqualTo(String value) {
            addCriterion("building_num_postfix =", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixNotEqualTo(String value) {
            addCriterion("building_num_postfix <>", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixGreaterThan(String value) {
            addCriterion("building_num_postfix >", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixGreaterThanOrEqualTo(String value) {
            addCriterion("building_num_postfix >=", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixLessThan(String value) {
            addCriterion("building_num_postfix <", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixLessThanOrEqualTo(String value) {
            addCriterion("building_num_postfix <=", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixLike(String value) {
            addCriterion("building_num_postfix like", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixNotLike(String value) {
            addCriterion("building_num_postfix not like", value, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixIn(List<String> values) {
            addCriterion("building_num_postfix in", values, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixNotIn(List<String> values) {
            addCriterion("building_num_postfix not in", values, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixBetween(String value1, String value2) {
            addCriterion("building_num_postfix between", value1, value2, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andBuildingNumPostfixNotBetween(String value1, String value2) {
            addCriterion("building_num_postfix not between", value1, value2, "buildingNumPostfix");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNull() {
            addCriterion("unit_num is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNotNull() {
            addCriterion("unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumEqualTo(String value) {
            addCriterion("unit_num =", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotEqualTo(String value) {
            addCriterion("unit_num <>", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThan(String value) {
            addCriterion("unit_num >", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThanOrEqualTo(String value) {
            addCriterion("unit_num >=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThan(String value) {
            addCriterion("unit_num <", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThanOrEqualTo(String value) {
            addCriterion("unit_num <=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLike(String value) {
            addCriterion("unit_num like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotLike(String value) {
            addCriterion("unit_num not like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIn(List<String> values) {
            addCriterion("unit_num in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotIn(List<String> values) {
            addCriterion("unit_num not in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumBetween(String value1, String value2) {
            addCriterion("unit_num between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotBetween(String value1, String value2) {
            addCriterion("unit_num not between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumEqualTo(String value) {
            addCriterion("room_num =", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotEqualTo(String value) {
            addCriterion("room_num <>", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThan(String value) {
            addCriterion("room_num >", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThanOrEqualTo(String value) {
            addCriterion("room_num >=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThan(String value) {
            addCriterion("room_num <", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThanOrEqualTo(String value) {
            addCriterion("room_num <=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLike(String value) {
            addCriterion("room_num like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotLike(String value) {
            addCriterion("room_num not like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIn(List<String> values) {
            addCriterion("room_num in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotIn(List<String> values) {
            addCriterion("room_num not in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumBetween(String value1, String value2) {
            addCriterion("room_num between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotBetween(String value1, String value2) {
            addCriterion("room_num not between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixIsNull() {
            addCriterion("room_num_postfix is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixIsNotNull() {
            addCriterion("room_num_postfix is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixEqualTo(String value) {
            addCriterion("room_num_postfix =", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixNotEqualTo(String value) {
            addCriterion("room_num_postfix <>", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixGreaterThan(String value) {
            addCriterion("room_num_postfix >", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixGreaterThanOrEqualTo(String value) {
            addCriterion("room_num_postfix >=", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixLessThan(String value) {
            addCriterion("room_num_postfix <", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixLessThanOrEqualTo(String value) {
            addCriterion("room_num_postfix <=", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixLike(String value) {
            addCriterion("room_num_postfix like", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixNotLike(String value) {
            addCriterion("room_num_postfix not like", value, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixIn(List<String> values) {
            addCriterion("room_num_postfix in", values, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixNotIn(List<String> values) {
            addCriterion("room_num_postfix not in", values, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixBetween(String value1, String value2) {
            addCriterion("room_num_postfix between", value1, value2, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andRoomNumPostfixNotBetween(String value1, String value2) {
            addCriterion("room_num_postfix not between", value1, value2, "roomNumPostfix");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddIsNull() {
            addCriterion("subsidiary_add is null");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddIsNotNull() {
            addCriterion("subsidiary_add is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddEqualTo(String value) {
            addCriterion("subsidiary_add =", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddNotEqualTo(String value) {
            addCriterion("subsidiary_add <>", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddGreaterThan(String value) {
            addCriterion("subsidiary_add >", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddGreaterThanOrEqualTo(String value) {
            addCriterion("subsidiary_add >=", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddLessThan(String value) {
            addCriterion("subsidiary_add <", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddLessThanOrEqualTo(String value) {
            addCriterion("subsidiary_add <=", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddLike(String value) {
            addCriterion("subsidiary_add like", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddNotLike(String value) {
            addCriterion("subsidiary_add not like", value, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddIn(List<String> values) {
            addCriterion("subsidiary_add in", values, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddNotIn(List<String> values) {
            addCriterion("subsidiary_add not in", values, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddBetween(String value1, String value2) {
            addCriterion("subsidiary_add between", value1, value2, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andSubsidiaryAddNotBetween(String value1, String value2) {
            addCriterion("subsidiary_add not between", value1, value2, "subsidiaryAdd");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPoiIsNull() {
            addCriterion("poi is null");
            return (Criteria) this;
        }

        public Criteria andPoiIsNotNull() {
            addCriterion("poi is not null");
            return (Criteria) this;
        }

        public Criteria andPoiEqualTo(String value) {
            addCriterion("poi =", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotEqualTo(String value) {
            addCriterion("poi <>", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThan(String value) {
            addCriterion("poi >", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThanOrEqualTo(String value) {
            addCriterion("poi >=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThan(String value) {
            addCriterion("poi <", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThanOrEqualTo(String value) {
            addCriterion("poi <=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLike(String value) {
            addCriterion("poi like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotLike(String value) {
            addCriterion("poi not like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiIn(List<String> values) {
            addCriterion("poi in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotIn(List<String> values) {
            addCriterion("poi not in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiBetween(String value1, String value2) {
            addCriterion("poi between", value1, value2, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotBetween(String value1, String value2) {
            addCriterion("poi not between", value1, value2, "poi");
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

        public Criteria andAddTypeIsNull() {
            addCriterion("add_type is null");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNotNull() {
            addCriterion("add_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddTypeEqualTo(String value) {
            addCriterion("add_type =", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotEqualTo(String value) {
            addCriterion("add_type <>", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThan(String value) {
            addCriterion("add_type >", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThanOrEqualTo(String value) {
            addCriterion("add_type >=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThan(String value) {
            addCriterion("add_type <", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThanOrEqualTo(String value) {
            addCriterion("add_type <=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLike(String value) {
            addCriterion("add_type like", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotLike(String value) {
            addCriterion("add_type not like", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeIn(List<String> values) {
            addCriterion("add_type in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotIn(List<String> values) {
            addCriterion("add_type not in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeBetween(String value1, String value2) {
            addCriterion("add_type between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotBetween(String value1, String value2) {
            addCriterion("add_type not between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIsNull() {
            addCriterion("floor_height is null");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIsNotNull() {
            addCriterion("floor_height is not null");
            return (Criteria) this;
        }

        public Criteria andFloorHeightEqualTo(String value) {
            addCriterion("floor_height =", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotEqualTo(String value) {
            addCriterion("floor_height <>", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightGreaterThan(String value) {
            addCriterion("floor_height >", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightGreaterThanOrEqualTo(String value) {
            addCriterion("floor_height >=", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLessThan(String value) {
            addCriterion("floor_height <", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLessThanOrEqualTo(String value) {
            addCriterion("floor_height <=", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLike(String value) {
            addCriterion("floor_height like", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotLike(String value) {
            addCriterion("floor_height not like", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIn(List<String> values) {
            addCriterion("floor_height in", values, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotIn(List<String> values) {
            addCriterion("floor_height not in", values, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightBetween(String value1, String value2) {
            addCriterion("floor_height between", value1, value2, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotBetween(String value1, String value2) {
            addCriterion("floor_height not between", value1, value2, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorPoiIsNull() {
            addCriterion("floor_poi is null");
            return (Criteria) this;
        }

        public Criteria andFloorPoiIsNotNull() {
            addCriterion("floor_poi is not null");
            return (Criteria) this;
        }

        public Criteria andFloorPoiEqualTo(String value) {
            addCriterion("floor_poi =", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiNotEqualTo(String value) {
            addCriterion("floor_poi <>", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiGreaterThan(String value) {
            addCriterion("floor_poi >", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiGreaterThanOrEqualTo(String value) {
            addCriterion("floor_poi >=", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiLessThan(String value) {
            addCriterion("floor_poi <", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiLessThanOrEqualTo(String value) {
            addCriterion("floor_poi <=", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiLike(String value) {
            addCriterion("floor_poi like", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiNotLike(String value) {
            addCriterion("floor_poi not like", value, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiIn(List<String> values) {
            addCriterion("floor_poi in", values, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiNotIn(List<String> values) {
            addCriterion("floor_poi not in", values, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiBetween(String value1, String value2) {
            addCriterion("floor_poi between", value1, value2, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andFloorPoiNotBetween(String value1, String value2) {
            addCriterion("floor_poi not between", value1, value2, "floorPoi");
            return (Criteria) this;
        }

        public Criteria andMiniheadingIsNull() {
            addCriterion("miniheading is null");
            return (Criteria) this;
        }

        public Criteria andMiniheadingIsNotNull() {
            addCriterion("miniheading is not null");
            return (Criteria) this;
        }

        public Criteria andMiniheadingEqualTo(String value) {
            addCriterion("miniheading =", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingNotEqualTo(String value) {
            addCriterion("miniheading <>", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingGreaterThan(String value) {
            addCriterion("miniheading >", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingGreaterThanOrEqualTo(String value) {
            addCriterion("miniheading >=", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingLessThan(String value) {
            addCriterion("miniheading <", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingLessThanOrEqualTo(String value) {
            addCriterion("miniheading <=", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingLike(String value) {
            addCriterion("miniheading like", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingNotLike(String value) {
            addCriterion("miniheading not like", value, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingIn(List<String> values) {
            addCriterion("miniheading in", values, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingNotIn(List<String> values) {
            addCriterion("miniheading not in", values, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingBetween(String value1, String value2) {
            addCriterion("miniheading between", value1, value2, "miniheading");
            return (Criteria) this;
        }

        public Criteria andMiniheadingNotBetween(String value1, String value2) {
            addCriterion("miniheading not between", value1, value2, "miniheading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingIsNull() {
            addCriterion("floor_heading is null");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingIsNotNull() {
            addCriterion("floor_heading is not null");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingEqualTo(String value) {
            addCriterion("floor_heading =", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingNotEqualTo(String value) {
            addCriterion("floor_heading <>", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingGreaterThan(String value) {
            addCriterion("floor_heading >", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("floor_heading >=", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingLessThan(String value) {
            addCriterion("floor_heading <", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingLessThanOrEqualTo(String value) {
            addCriterion("floor_heading <=", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingLike(String value) {
            addCriterion("floor_heading like", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingNotLike(String value) {
            addCriterion("floor_heading not like", value, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingIn(List<String> values) {
            addCriterion("floor_heading in", values, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingNotIn(List<String> values) {
            addCriterion("floor_heading not in", values, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingBetween(String value1, String value2) {
            addCriterion("floor_heading between", value1, value2, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andFloorHeadingNotBetween(String value1, String value2) {
            addCriterion("floor_heading not between", value1, value2, "floorHeading");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("add_date is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("add_date is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(String value) {
            addCriterion("add_date =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(String value) {
            addCriterion("add_date <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(String value) {
            addCriterion("add_date >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(String value) {
            addCriterion("add_date >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(String value) {
            addCriterion("add_date <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(String value) {
            addCriterion("add_date <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLike(String value) {
            addCriterion("add_date like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotLike(String value) {
            addCriterion("add_date not like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<String> values) {
            addCriterion("add_date in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<String> values) {
            addCriterion("add_date not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(String value1, String value2) {
            addCriterion("add_date between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(String value1, String value2) {
            addCriterion("add_date not between", value1, value2, "addDate");
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