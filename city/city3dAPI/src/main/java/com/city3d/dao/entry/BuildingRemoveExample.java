package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class BuildingRemoveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingRemoveExample() {
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

        public Criteria andRemoveIdIsNull() {
            addCriterion("remove_id is null");
            return (Criteria) this;
        }

        public Criteria andRemoveIdIsNotNull() {
            addCriterion("remove_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveIdEqualTo(String value) {
            addCriterion("remove_id =", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotEqualTo(String value) {
            addCriterion("remove_id <>", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdGreaterThan(String value) {
            addCriterion("remove_id >", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdGreaterThanOrEqualTo(String value) {
            addCriterion("remove_id >=", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdLessThan(String value) {
            addCriterion("remove_id <", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdLessThanOrEqualTo(String value) {
            addCriterion("remove_id <=", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdLike(String value) {
            addCriterion("remove_id like", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotLike(String value) {
            addCriterion("remove_id not like", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdIn(List<String> values) {
            addCriterion("remove_id in", values, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotIn(List<String> values) {
            addCriterion("remove_id not in", values, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdBetween(String value1, String value2) {
            addCriterion("remove_id between", value1, value2, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotBetween(String value1, String value2) {
            addCriterion("remove_id not between", value1, value2, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveNameIsNull() {
            addCriterion("remove_name is null");
            return (Criteria) this;
        }

        public Criteria andRemoveNameIsNotNull() {
            addCriterion("remove_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveNameEqualTo(String value) {
            addCriterion("remove_name =", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameNotEqualTo(String value) {
            addCriterion("remove_name <>", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameGreaterThan(String value) {
            addCriterion("remove_name >", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameGreaterThanOrEqualTo(String value) {
            addCriterion("remove_name >=", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameLessThan(String value) {
            addCriterion("remove_name <", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameLessThanOrEqualTo(String value) {
            addCriterion("remove_name <=", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameLike(String value) {
            addCriterion("remove_name like", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameNotLike(String value) {
            addCriterion("remove_name not like", value, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameIn(List<String> values) {
            addCriterion("remove_name in", values, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameNotIn(List<String> values) {
            addCriterion("remove_name not in", values, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameBetween(String value1, String value2) {
            addCriterion("remove_name between", value1, value2, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveNameNotBetween(String value1, String value2) {
            addCriterion("remove_name not between", value1, value2, "removeName");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteIsNull() {
            addCriterion("remove_site is null");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteIsNotNull() {
            addCriterion("remove_site is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteEqualTo(String value) {
            addCriterion("remove_site =", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteNotEqualTo(String value) {
            addCriterion("remove_site <>", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteGreaterThan(String value) {
            addCriterion("remove_site >", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteGreaterThanOrEqualTo(String value) {
            addCriterion("remove_site >=", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteLessThan(String value) {
            addCriterion("remove_site <", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteLessThanOrEqualTo(String value) {
            addCriterion("remove_site <=", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteLike(String value) {
            addCriterion("remove_site like", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteNotLike(String value) {
            addCriterion("remove_site not like", value, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteIn(List<String> values) {
            addCriterion("remove_site in", values, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteNotIn(List<String> values) {
            addCriterion("remove_site not in", values, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteBetween(String value1, String value2) {
            addCriterion("remove_site between", value1, value2, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveSiteNotBetween(String value1, String value2) {
            addCriterion("remove_site not between", value1, value2, "removeSite");
            return (Criteria) this;
        }

        public Criteria andRemoveTelIsNull() {
            addCriterion("remove_tel is null");
            return (Criteria) this;
        }

        public Criteria andRemoveTelIsNotNull() {
            addCriterion("remove_tel is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveTelEqualTo(String value) {
            addCriterion("remove_tel =", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelNotEqualTo(String value) {
            addCriterion("remove_tel <>", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelGreaterThan(String value) {
            addCriterion("remove_tel >", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelGreaterThanOrEqualTo(String value) {
            addCriterion("remove_tel >=", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelLessThan(String value) {
            addCriterion("remove_tel <", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelLessThanOrEqualTo(String value) {
            addCriterion("remove_tel <=", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelLike(String value) {
            addCriterion("remove_tel like", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelNotLike(String value) {
            addCriterion("remove_tel not like", value, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelIn(List<String> values) {
            addCriterion("remove_tel in", values, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelNotIn(List<String> values) {
            addCriterion("remove_tel not in", values, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelBetween(String value1, String value2) {
            addCriterion("remove_tel between", value1, value2, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveTelNotBetween(String value1, String value2) {
            addCriterion("remove_tel not between", value1, value2, "removeTel");
            return (Criteria) this;
        }

        public Criteria andRemoveCardIsNull() {
            addCriterion("remove_card is null");
            return (Criteria) this;
        }

        public Criteria andRemoveCardIsNotNull() {
            addCriterion("remove_card is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveCardEqualTo(String value) {
            addCriterion("remove_card =", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardNotEqualTo(String value) {
            addCriterion("remove_card <>", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardGreaterThan(String value) {
            addCriterion("remove_card >", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardGreaterThanOrEqualTo(String value) {
            addCriterion("remove_card >=", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardLessThan(String value) {
            addCriterion("remove_card <", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardLessThanOrEqualTo(String value) {
            addCriterion("remove_card <=", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardLike(String value) {
            addCriterion("remove_card like", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardNotLike(String value) {
            addCriterion("remove_card not like", value, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardIn(List<String> values) {
            addCriterion("remove_card in", values, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardNotIn(List<String> values) {
            addCriterion("remove_card not in", values, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardBetween(String value1, String value2) {
            addCriterion("remove_card between", value1, value2, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveCardNotBetween(String value1, String value2) {
            addCriterion("remove_card not between", value1, value2, "removeCard");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumIsNull() {
            addCriterion("remove_land_num is null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumIsNotNull() {
            addCriterion("remove_land_num is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumEqualTo(String value) {
            addCriterion("remove_land_num =", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumNotEqualTo(String value) {
            addCriterion("remove_land_num <>", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumGreaterThan(String value) {
            addCriterion("remove_land_num >", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumGreaterThanOrEqualTo(String value) {
            addCriterion("remove_land_num >=", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumLessThan(String value) {
            addCriterion("remove_land_num <", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumLessThanOrEqualTo(String value) {
            addCriterion("remove_land_num <=", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumLike(String value) {
            addCriterion("remove_land_num like", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumNotLike(String value) {
            addCriterion("remove_land_num not like", value, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumIn(List<String> values) {
            addCriterion("remove_land_num in", values, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumNotIn(List<String> values) {
            addCriterion("remove_land_num not in", values, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumBetween(String value1, String value2) {
            addCriterion("remove_land_num between", value1, value2, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveLandNumNotBetween(String value1, String value2) {
            addCriterion("remove_land_num not between", value1, value2, "removeLandNum");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeIsNull() {
            addCriterion("remove_pro_type is null");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeIsNotNull() {
            addCriterion("remove_pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeEqualTo(String value) {
            addCriterion("remove_pro_type =", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeNotEqualTo(String value) {
            addCriterion("remove_pro_type <>", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeGreaterThan(String value) {
            addCriterion("remove_pro_type >", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("remove_pro_type >=", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeLessThan(String value) {
            addCriterion("remove_pro_type <", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeLessThanOrEqualTo(String value) {
            addCriterion("remove_pro_type <=", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeLike(String value) {
            addCriterion("remove_pro_type like", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeNotLike(String value) {
            addCriterion("remove_pro_type not like", value, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeIn(List<String> values) {
            addCriterion("remove_pro_type in", values, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeNotIn(List<String> values) {
            addCriterion("remove_pro_type not in", values, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeBetween(String value1, String value2) {
            addCriterion("remove_pro_type between", value1, value2, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveProTypeNotBetween(String value1, String value2) {
            addCriterion("remove_pro_type not between", value1, value2, "removeProType");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaIsNull() {
            addCriterion("remove_land_area is null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaIsNotNull() {
            addCriterion("remove_land_area is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaEqualTo(String value) {
            addCriterion("remove_land_area =", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNotEqualTo(String value) {
            addCriterion("remove_land_area <>", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaGreaterThan(String value) {
            addCriterion("remove_land_area >", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaGreaterThanOrEqualTo(String value) {
            addCriterion("remove_land_area >=", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaLessThan(String value) {
            addCriterion("remove_land_area <", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaLessThanOrEqualTo(String value) {
            addCriterion("remove_land_area <=", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaLike(String value) {
            addCriterion("remove_land_area like", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNotLike(String value) {
            addCriterion("remove_land_area not like", value, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaIn(List<String> values) {
            addCriterion("remove_land_area in", values, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNotIn(List<String> values) {
            addCriterion("remove_land_area not in", values, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaBetween(String value1, String value2) {
            addCriterion("remove_land_area between", value1, value2, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNotBetween(String value1, String value2) {
            addCriterion("remove_land_area not between", value1, value2, "removeLandArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumIsNull() {
            addCriterion("remove_house_num is null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumIsNotNull() {
            addCriterion("remove_house_num is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumEqualTo(String value) {
            addCriterion("remove_house_num =", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumNotEqualTo(String value) {
            addCriterion("remove_house_num <>", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumGreaterThan(String value) {
            addCriterion("remove_house_num >", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumGreaterThanOrEqualTo(String value) {
            addCriterion("remove_house_num >=", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumLessThan(String value) {
            addCriterion("remove_house_num <", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumLessThanOrEqualTo(String value) {
            addCriterion("remove_house_num <=", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumLike(String value) {
            addCriterion("remove_house_num like", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumNotLike(String value) {
            addCriterion("remove_house_num not like", value, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumIn(List<String> values) {
            addCriterion("remove_house_num in", values, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumNotIn(List<String> values) {
            addCriterion("remove_house_num not in", values, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumBetween(String value1, String value2) {
            addCriterion("remove_house_num between", value1, value2, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseNumNotBetween(String value1, String value2) {
            addCriterion("remove_house_num not between", value1, value2, "removeHouseNum");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaIsNull() {
            addCriterion("remove_house_area is null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaIsNotNull() {
            addCriterion("remove_house_area is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaEqualTo(String value) {
            addCriterion("remove_house_area =", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaNotEqualTo(String value) {
            addCriterion("remove_house_area <>", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaGreaterThan(String value) {
            addCriterion("remove_house_area >", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("remove_house_area >=", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaLessThan(String value) {
            addCriterion("remove_house_area <", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaLessThanOrEqualTo(String value) {
            addCriterion("remove_house_area <=", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaLike(String value) {
            addCriterion("remove_house_area like", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaNotLike(String value) {
            addCriterion("remove_house_area not like", value, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaIn(List<String> values) {
            addCriterion("remove_house_area in", values, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaNotIn(List<String> values) {
            addCriterion("remove_house_area not in", values, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaBetween(String value1, String value2) {
            addCriterion("remove_house_area between", value1, value2, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaNotBetween(String value1, String value2) {
            addCriterion("remove_house_area not between", value1, value2, "removeHouseArea");
            return (Criteria) this;
        }

        public Criteria andRemoveStateIsNull() {
            addCriterion("remove_state is null");
            return (Criteria) this;
        }

        public Criteria andRemoveStateIsNotNull() {
            addCriterion("remove_state is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveStateEqualTo(String value) {
            addCriterion("remove_state =", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateNotEqualTo(String value) {
            addCriterion("remove_state <>", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateGreaterThan(String value) {
            addCriterion("remove_state >", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateGreaterThanOrEqualTo(String value) {
            addCriterion("remove_state >=", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateLessThan(String value) {
            addCriterion("remove_state <", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateLessThanOrEqualTo(String value) {
            addCriterion("remove_state <=", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateLike(String value) {
            addCriterion("remove_state like", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateNotLike(String value) {
            addCriterion("remove_state not like", value, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateIn(List<String> values) {
            addCriterion("remove_state in", values, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateNotIn(List<String> values) {
            addCriterion("remove_state not in", values, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateBetween(String value1, String value2) {
            addCriterion("remove_state between", value1, value2, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveStateNotBetween(String value1, String value2) {
            addCriterion("remove_state not between", value1, value2, "removeState");
            return (Criteria) this;
        }

        public Criteria andRemoveUseIsNull() {
            addCriterion("remove_use is null");
            return (Criteria) this;
        }

        public Criteria andRemoveUseIsNotNull() {
            addCriterion("remove_use is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveUseEqualTo(String value) {
            addCriterion("remove_use =", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseNotEqualTo(String value) {
            addCriterion("remove_use <>", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseGreaterThan(String value) {
            addCriterion("remove_use >", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseGreaterThanOrEqualTo(String value) {
            addCriterion("remove_use >=", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseLessThan(String value) {
            addCriterion("remove_use <", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseLessThanOrEqualTo(String value) {
            addCriterion("remove_use <=", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseLike(String value) {
            addCriterion("remove_use like", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseNotLike(String value) {
            addCriterion("remove_use not like", value, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseIn(List<String> values) {
            addCriterion("remove_use in", values, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseNotIn(List<String> values) {
            addCriterion("remove_use not in", values, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseBetween(String value1, String value2) {
            addCriterion("remove_use between", value1, value2, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveUseNotBetween(String value1, String value2) {
            addCriterion("remove_use not between", value1, value2, "removeUse");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckIsNull() {
            addCriterion("remove_house_area_check is null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckIsNotNull() {
            addCriterion("remove_house_area_check is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckEqualTo(String value) {
            addCriterion("remove_house_area_check =", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckNotEqualTo(String value) {
            addCriterion("remove_house_area_check <>", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckGreaterThan(String value) {
            addCriterion("remove_house_area_check >", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckGreaterThanOrEqualTo(String value) {
            addCriterion("remove_house_area_check >=", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckLessThan(String value) {
            addCriterion("remove_house_area_check <", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckLessThanOrEqualTo(String value) {
            addCriterion("remove_house_area_check <=", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckLike(String value) {
            addCriterion("remove_house_area_check like", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckNotLike(String value) {
            addCriterion("remove_house_area_check not like", value, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckIn(List<String> values) {
            addCriterion("remove_house_area_check in", values, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckNotIn(List<String> values) {
            addCriterion("remove_house_area_check not in", values, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckBetween(String value1, String value2) {
            addCriterion("remove_house_area_check between", value1, value2, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveHouseAreaCheckNotBetween(String value1, String value2) {
            addCriterion("remove_house_area_check not between", value1, value2, "removeHouseAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckIsNull() {
            addCriterion("remove_building_area_check is null");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckIsNotNull() {
            addCriterion("remove_building_area_check is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckEqualTo(String value) {
            addCriterion("remove_building_area_check =", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckNotEqualTo(String value) {
            addCriterion("remove_building_area_check <>", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckGreaterThan(String value) {
            addCriterion("remove_building_area_check >", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckGreaterThanOrEqualTo(String value) {
            addCriterion("remove_building_area_check >=", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckLessThan(String value) {
            addCriterion("remove_building_area_check <", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckLessThanOrEqualTo(String value) {
            addCriterion("remove_building_area_check <=", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckLike(String value) {
            addCriterion("remove_building_area_check like", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckNotLike(String value) {
            addCriterion("remove_building_area_check not like", value, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckIn(List<String> values) {
            addCriterion("remove_building_area_check in", values, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckNotIn(List<String> values) {
            addCriterion("remove_building_area_check not in", values, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckBetween(String value1, String value2) {
            addCriterion("remove_building_area_check between", value1, value2, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveBuildingAreaCheckNotBetween(String value1, String value2) {
            addCriterion("remove_building_area_check not between", value1, value2, "removeBuildingAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerIsNull() {
            addCriterion("remove_area_no_cer is null");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerIsNotNull() {
            addCriterion("remove_area_no_cer is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerEqualTo(String value) {
            addCriterion("remove_area_no_cer =", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerNotEqualTo(String value) {
            addCriterion("remove_area_no_cer <>", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerGreaterThan(String value) {
            addCriterion("remove_area_no_cer >", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerGreaterThanOrEqualTo(String value) {
            addCriterion("remove_area_no_cer >=", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerLessThan(String value) {
            addCriterion("remove_area_no_cer <", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerLessThanOrEqualTo(String value) {
            addCriterion("remove_area_no_cer <=", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerLike(String value) {
            addCriterion("remove_area_no_cer like", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerNotLike(String value) {
            addCriterion("remove_area_no_cer not like", value, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerIn(List<String> values) {
            addCriterion("remove_area_no_cer in", values, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerNotIn(List<String> values) {
            addCriterion("remove_area_no_cer not in", values, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerBetween(String value1, String value2) {
            addCriterion("remove_area_no_cer between", value1, value2, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveAreaNoCerNotBetween(String value1, String value2) {
            addCriterion("remove_area_no_cer not between", value1, value2, "removeAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckIsNull() {
            addCriterion("remove_land_area_check is null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckIsNotNull() {
            addCriterion("remove_land_area_check is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckEqualTo(String value) {
            addCriterion("remove_land_area_check =", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckNotEqualTo(String value) {
            addCriterion("remove_land_area_check <>", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckGreaterThan(String value) {
            addCriterion("remove_land_area_check >", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckGreaterThanOrEqualTo(String value) {
            addCriterion("remove_land_area_check >=", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckLessThan(String value) {
            addCriterion("remove_land_area_check <", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckLessThanOrEqualTo(String value) {
            addCriterion("remove_land_area_check <=", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckLike(String value) {
            addCriterion("remove_land_area_check like", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckNotLike(String value) {
            addCriterion("remove_land_area_check not like", value, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckIn(List<String> values) {
            addCriterion("remove_land_area_check in", values, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckNotIn(List<String> values) {
            addCriterion("remove_land_area_check not in", values, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckBetween(String value1, String value2) {
            addCriterion("remove_land_area_check between", value1, value2, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaCheckNotBetween(String value1, String value2) {
            addCriterion("remove_land_area_check not between", value1, value2, "removeLandAreaCheck");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkIsNull() {
            addCriterion("remove_land_area_ok is null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkIsNotNull() {
            addCriterion("remove_land_area_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkEqualTo(String value) {
            addCriterion("remove_land_area_ok =", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkNotEqualTo(String value) {
            addCriterion("remove_land_area_ok <>", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkGreaterThan(String value) {
            addCriterion("remove_land_area_ok >", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkGreaterThanOrEqualTo(String value) {
            addCriterion("remove_land_area_ok >=", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkLessThan(String value) {
            addCriterion("remove_land_area_ok <", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkLessThanOrEqualTo(String value) {
            addCriterion("remove_land_area_ok <=", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkLike(String value) {
            addCriterion("remove_land_area_ok like", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkNotLike(String value) {
            addCriterion("remove_land_area_ok not like", value, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkIn(List<String> values) {
            addCriterion("remove_land_area_ok in", values, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkNotIn(List<String> values) {
            addCriterion("remove_land_area_ok not in", values, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkBetween(String value1, String value2) {
            addCriterion("remove_land_area_ok between", value1, value2, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaOkNotBetween(String value1, String value2) {
            addCriterion("remove_land_area_ok not between", value1, value2, "removeLandAreaOk");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerIsNull() {
            addCriterion("remove_land_area_no_cer is null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerIsNotNull() {
            addCriterion("remove_land_area_no_cer is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerEqualTo(String value) {
            addCriterion("remove_land_area_no_cer =", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerNotEqualTo(String value) {
            addCriterion("remove_land_area_no_cer <>", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerGreaterThan(String value) {
            addCriterion("remove_land_area_no_cer >", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerGreaterThanOrEqualTo(String value) {
            addCriterion("remove_land_area_no_cer >=", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerLessThan(String value) {
            addCriterion("remove_land_area_no_cer <", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerLessThanOrEqualTo(String value) {
            addCriterion("remove_land_area_no_cer <=", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerLike(String value) {
            addCriterion("remove_land_area_no_cer like", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerNotLike(String value) {
            addCriterion("remove_land_area_no_cer not like", value, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerIn(List<String> values) {
            addCriterion("remove_land_area_no_cer in", values, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerNotIn(List<String> values) {
            addCriterion("remove_land_area_no_cer not in", values, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerBetween(String value1, String value2) {
            addCriterion("remove_land_area_no_cer between", value1, value2, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveLandAreaNoCerNotBetween(String value1, String value2) {
            addCriterion("remove_land_area_no_cer not between", value1, value2, "removeLandAreaNoCer");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteIsNull() {
            addCriterion("remove_note is null");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteIsNotNull() {
            addCriterion("remove_note is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteEqualTo(String value) {
            addCriterion("remove_note =", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteNotEqualTo(String value) {
            addCriterion("remove_note <>", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteGreaterThan(String value) {
            addCriterion("remove_note >", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteGreaterThanOrEqualTo(String value) {
            addCriterion("remove_note >=", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteLessThan(String value) {
            addCriterion("remove_note <", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteLessThanOrEqualTo(String value) {
            addCriterion("remove_note <=", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteLike(String value) {
            addCriterion("remove_note like", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteNotLike(String value) {
            addCriterion("remove_note not like", value, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteIn(List<String> values) {
            addCriterion("remove_note in", values, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteNotIn(List<String> values) {
            addCriterion("remove_note not in", values, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteBetween(String value1, String value2) {
            addCriterion("remove_note between", value1, value2, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveNoteNotBetween(String value1, String value2) {
            addCriterion("remove_note not between", value1, value2, "removeNote");
            return (Criteria) this;
        }

        public Criteria andRemoveDateIsNull() {
            addCriterion("remove_date is null");
            return (Criteria) this;
        }

        public Criteria andRemoveDateIsNotNull() {
            addCriterion("remove_date is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveDateEqualTo(String value) {
            addCriterion("remove_date =", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateNotEqualTo(String value) {
            addCriterion("remove_date <>", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateGreaterThan(String value) {
            addCriterion("remove_date >", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateGreaterThanOrEqualTo(String value) {
            addCriterion("remove_date >=", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateLessThan(String value) {
            addCriterion("remove_date <", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateLessThanOrEqualTo(String value) {
            addCriterion("remove_date <=", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateLike(String value) {
            addCriterion("remove_date like", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateNotLike(String value) {
            addCriterion("remove_date not like", value, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateIn(List<String> values) {
            addCriterion("remove_date in", values, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateNotIn(List<String> values) {
            addCriterion("remove_date not in", values, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateBetween(String value1, String value2) {
            addCriterion("remove_date between", value1, value2, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveDateNotBetween(String value1, String value2) {
            addCriterion("remove_date not between", value1, value2, "removeDate");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerIsNull() {
            addCriterion("remove_corner is null");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerIsNotNull() {
            addCriterion("remove_corner is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerEqualTo(String value) {
            addCriterion("remove_corner =", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerNotEqualTo(String value) {
            addCriterion("remove_corner <>", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerGreaterThan(String value) {
            addCriterion("remove_corner >", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerGreaterThanOrEqualTo(String value) {
            addCriterion("remove_corner >=", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerLessThan(String value) {
            addCriterion("remove_corner <", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerLessThanOrEqualTo(String value) {
            addCriterion("remove_corner <=", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerLike(String value) {
            addCriterion("remove_corner like", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerNotLike(String value) {
            addCriterion("remove_corner not like", value, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerIn(List<String> values) {
            addCriterion("remove_corner in", values, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerNotIn(List<String> values) {
            addCriterion("remove_corner not in", values, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerBetween(String value1, String value2) {
            addCriterion("remove_corner between", value1, value2, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemoveCornerNotBetween(String value1, String value2) {
            addCriterion("remove_corner not between", value1, value2, "removeCorner");
            return (Criteria) this;
        }

        public Criteria andRemovePic1IsNull() {
            addCriterion("remove_pic1 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePic1IsNotNull() {
            addCriterion("remove_pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePic1EqualTo(String value) {
            addCriterion("remove_pic1 =", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1NotEqualTo(String value) {
            addCriterion("remove_pic1 <>", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1GreaterThan(String value) {
            addCriterion("remove_pic1 >", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic1 >=", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1LessThan(String value) {
            addCriterion("remove_pic1 <", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1LessThanOrEqualTo(String value) {
            addCriterion("remove_pic1 <=", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1Like(String value) {
            addCriterion("remove_pic1 like", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1NotLike(String value) {
            addCriterion("remove_pic1 not like", value, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1In(List<String> values) {
            addCriterion("remove_pic1 in", values, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1NotIn(List<String> values) {
            addCriterion("remove_pic1 not in", values, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1Between(String value1, String value2) {
            addCriterion("remove_pic1 between", value1, value2, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePic1NotBetween(String value1, String value2) {
            addCriterion("remove_pic1 not between", value1, value2, "removePic1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1IsNull() {
            addCriterion("remove_pic_pos1 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1IsNotNull() {
            addCriterion("remove_pic_pos1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1EqualTo(String value) {
            addCriterion("remove_pic_pos1 =", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1NotEqualTo(String value) {
            addCriterion("remove_pic_pos1 <>", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1GreaterThan(String value) {
            addCriterion("remove_pic_pos1 >", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos1 >=", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1LessThan(String value) {
            addCriterion("remove_pic_pos1 <", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1LessThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos1 <=", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1Like(String value) {
            addCriterion("remove_pic_pos1 like", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1NotLike(String value) {
            addCriterion("remove_pic_pos1 not like", value, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1In(List<String> values) {
            addCriterion("remove_pic_pos1 in", values, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1NotIn(List<String> values) {
            addCriterion("remove_pic_pos1 not in", values, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1Between(String value1, String value2) {
            addCriterion("remove_pic_pos1 between", value1, value2, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos1NotBetween(String value1, String value2) {
            addCriterion("remove_pic_pos1 not between", value1, value2, "removePicPos1");
            return (Criteria) this;
        }

        public Criteria andRemovePic2IsNull() {
            addCriterion("remove_pic2 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePic2IsNotNull() {
            addCriterion("remove_pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePic2EqualTo(String value) {
            addCriterion("remove_pic2 =", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2NotEqualTo(String value) {
            addCriterion("remove_pic2 <>", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2GreaterThan(String value) {
            addCriterion("remove_pic2 >", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic2 >=", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2LessThan(String value) {
            addCriterion("remove_pic2 <", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2LessThanOrEqualTo(String value) {
            addCriterion("remove_pic2 <=", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2Like(String value) {
            addCriterion("remove_pic2 like", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2NotLike(String value) {
            addCriterion("remove_pic2 not like", value, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2In(List<String> values) {
            addCriterion("remove_pic2 in", values, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2NotIn(List<String> values) {
            addCriterion("remove_pic2 not in", values, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2Between(String value1, String value2) {
            addCriterion("remove_pic2 between", value1, value2, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePic2NotBetween(String value1, String value2) {
            addCriterion("remove_pic2 not between", value1, value2, "removePic2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2IsNull() {
            addCriterion("remove_pic_pos2 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2IsNotNull() {
            addCriterion("remove_pic_pos2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2EqualTo(String value) {
            addCriterion("remove_pic_pos2 =", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2NotEqualTo(String value) {
            addCriterion("remove_pic_pos2 <>", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2GreaterThan(String value) {
            addCriterion("remove_pic_pos2 >", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos2 >=", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2LessThan(String value) {
            addCriterion("remove_pic_pos2 <", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2LessThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos2 <=", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2Like(String value) {
            addCriterion("remove_pic_pos2 like", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2NotLike(String value) {
            addCriterion("remove_pic_pos2 not like", value, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2In(List<String> values) {
            addCriterion("remove_pic_pos2 in", values, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2NotIn(List<String> values) {
            addCriterion("remove_pic_pos2 not in", values, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2Between(String value1, String value2) {
            addCriterion("remove_pic_pos2 between", value1, value2, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos2NotBetween(String value1, String value2) {
            addCriterion("remove_pic_pos2 not between", value1, value2, "removePicPos2");
            return (Criteria) this;
        }

        public Criteria andRemovePic3IsNull() {
            addCriterion("remove_pic3 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePic3IsNotNull() {
            addCriterion("remove_pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePic3EqualTo(String value) {
            addCriterion("remove_pic3 =", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3NotEqualTo(String value) {
            addCriterion("remove_pic3 <>", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3GreaterThan(String value) {
            addCriterion("remove_pic3 >", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic3 >=", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3LessThan(String value) {
            addCriterion("remove_pic3 <", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3LessThanOrEqualTo(String value) {
            addCriterion("remove_pic3 <=", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3Like(String value) {
            addCriterion("remove_pic3 like", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3NotLike(String value) {
            addCriterion("remove_pic3 not like", value, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3In(List<String> values) {
            addCriterion("remove_pic3 in", values, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3NotIn(List<String> values) {
            addCriterion("remove_pic3 not in", values, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3Between(String value1, String value2) {
            addCriterion("remove_pic3 between", value1, value2, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePic3NotBetween(String value1, String value2) {
            addCriterion("remove_pic3 not between", value1, value2, "removePic3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3IsNull() {
            addCriterion("remove_pic_pos3 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3IsNotNull() {
            addCriterion("remove_pic_pos3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3EqualTo(String value) {
            addCriterion("remove_pic_pos3 =", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3NotEqualTo(String value) {
            addCriterion("remove_pic_pos3 <>", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3GreaterThan(String value) {
            addCriterion("remove_pic_pos3 >", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos3 >=", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3LessThan(String value) {
            addCriterion("remove_pic_pos3 <", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3LessThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos3 <=", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3Like(String value) {
            addCriterion("remove_pic_pos3 like", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3NotLike(String value) {
            addCriterion("remove_pic_pos3 not like", value, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3In(List<String> values) {
            addCriterion("remove_pic_pos3 in", values, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3NotIn(List<String> values) {
            addCriterion("remove_pic_pos3 not in", values, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3Between(String value1, String value2) {
            addCriterion("remove_pic_pos3 between", value1, value2, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos3NotBetween(String value1, String value2) {
            addCriterion("remove_pic_pos3 not between", value1, value2, "removePicPos3");
            return (Criteria) this;
        }

        public Criteria andRemovePic4IsNull() {
            addCriterion("remove_pic4 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePic4IsNotNull() {
            addCriterion("remove_pic4 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePic4EqualTo(String value) {
            addCriterion("remove_pic4 =", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4NotEqualTo(String value) {
            addCriterion("remove_pic4 <>", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4GreaterThan(String value) {
            addCriterion("remove_pic4 >", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic4 >=", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4LessThan(String value) {
            addCriterion("remove_pic4 <", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4LessThanOrEqualTo(String value) {
            addCriterion("remove_pic4 <=", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4Like(String value) {
            addCriterion("remove_pic4 like", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4NotLike(String value) {
            addCriterion("remove_pic4 not like", value, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4In(List<String> values) {
            addCriterion("remove_pic4 in", values, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4NotIn(List<String> values) {
            addCriterion("remove_pic4 not in", values, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4Between(String value1, String value2) {
            addCriterion("remove_pic4 between", value1, value2, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePic4NotBetween(String value1, String value2) {
            addCriterion("remove_pic4 not between", value1, value2, "removePic4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4IsNull() {
            addCriterion("remove_pic_pos4 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4IsNotNull() {
            addCriterion("remove_pic_pos4 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4EqualTo(String value) {
            addCriterion("remove_pic_pos4 =", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4NotEqualTo(String value) {
            addCriterion("remove_pic_pos4 <>", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4GreaterThan(String value) {
            addCriterion("remove_pic_pos4 >", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos4 >=", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4LessThan(String value) {
            addCriterion("remove_pic_pos4 <", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4LessThanOrEqualTo(String value) {
            addCriterion("remove_pic_pos4 <=", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4Like(String value) {
            addCriterion("remove_pic_pos4 like", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4NotLike(String value) {
            addCriterion("remove_pic_pos4 not like", value, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4In(List<String> values) {
            addCriterion("remove_pic_pos4 in", values, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4NotIn(List<String> values) {
            addCriterion("remove_pic_pos4 not in", values, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4Between(String value1, String value2) {
            addCriterion("remove_pic_pos4 between", value1, value2, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePicPos4NotBetween(String value1, String value2) {
            addCriterion("remove_pic_pos4 not between", value1, value2, "removePicPos4");
            return (Criteria) this;
        }

        public Criteria andRemovePdfIsNull() {
            addCriterion("remove_pdf is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdfIsNotNull() {
            addCriterion("remove_pdf is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdfEqualTo(String value) {
            addCriterion("remove_pdf =", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfNotEqualTo(String value) {
            addCriterion("remove_pdf <>", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfGreaterThan(String value) {
            addCriterion("remove_pdf >", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfGreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf >=", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfLessThan(String value) {
            addCriterion("remove_pdf <", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfLessThanOrEqualTo(String value) {
            addCriterion("remove_pdf <=", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfLike(String value) {
            addCriterion("remove_pdf like", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfNotLike(String value) {
            addCriterion("remove_pdf not like", value, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfIn(List<String> values) {
            addCriterion("remove_pdf in", values, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfNotIn(List<String> values) {
            addCriterion("remove_pdf not in", values, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfBetween(String value1, String value2) {
            addCriterion("remove_pdf between", value1, value2, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemovePdfNotBetween(String value1, String value2) {
            addCriterion("remove_pdf not between", value1, value2, "removePdf");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIsNull() {
            addCriterion("remove_sign is null");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIsNotNull() {
            addCriterion("remove_sign is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveSignEqualTo(String value) {
            addCriterion("remove_sign =", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotEqualTo(String value) {
            addCriterion("remove_sign <>", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignGreaterThan(String value) {
            addCriterion("remove_sign >", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignGreaterThanOrEqualTo(String value) {
            addCriterion("remove_sign >=", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignLessThan(String value) {
            addCriterion("remove_sign <", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignLessThanOrEqualTo(String value) {
            addCriterion("remove_sign <=", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignLike(String value) {
            addCriterion("remove_sign like", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotLike(String value) {
            addCriterion("remove_sign not like", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIn(List<String> values) {
            addCriterion("remove_sign in", values, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotIn(List<String> values) {
            addCriterion("remove_sign not in", values, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignBetween(String value1, String value2) {
            addCriterion("remove_sign between", value1, value2, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotBetween(String value1, String value2) {
            addCriterion("remove_sign not between", value1, value2, "removeSign");
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

        public Criteria andRemoveTopIsNull() {
            addCriterion("remove_top is null");
            return (Criteria) this;
        }

        public Criteria andRemoveTopIsNotNull() {
            addCriterion("remove_top is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveTopEqualTo(String value) {
            addCriterion("remove_top =", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopNotEqualTo(String value) {
            addCriterion("remove_top <>", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopGreaterThan(String value) {
            addCriterion("remove_top >", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopGreaterThanOrEqualTo(String value) {
            addCriterion("remove_top >=", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopLessThan(String value) {
            addCriterion("remove_top <", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopLessThanOrEqualTo(String value) {
            addCriterion("remove_top <=", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopLike(String value) {
            addCriterion("remove_top like", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopNotLike(String value) {
            addCriterion("remove_top not like", value, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopIn(List<String> values) {
            addCriterion("remove_top in", values, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopNotIn(List<String> values) {
            addCriterion("remove_top not in", values, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopBetween(String value1, String value2) {
            addCriterion("remove_top between", value1, value2, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemoveTopNotBetween(String value1, String value2) {
            addCriterion("remove_top not between", value1, value2, "removeTop");
            return (Criteria) this;
        }

        public Criteria andRemovePidIsNull() {
            addCriterion("remove_pid is null");
            return (Criteria) this;
        }

        public Criteria andRemovePidIsNotNull() {
            addCriterion("remove_pid is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePidEqualTo(String value) {
            addCriterion("remove_pid =", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidNotEqualTo(String value) {
            addCriterion("remove_pid <>", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidGreaterThan(String value) {
            addCriterion("remove_pid >", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidGreaterThanOrEqualTo(String value) {
            addCriterion("remove_pid >=", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidLessThan(String value) {
            addCriterion("remove_pid <", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidLessThanOrEqualTo(String value) {
            addCriterion("remove_pid <=", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidLike(String value) {
            addCriterion("remove_pid like", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidNotLike(String value) {
            addCriterion("remove_pid not like", value, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidIn(List<String> values) {
            addCriterion("remove_pid in", values, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidNotIn(List<String> values) {
            addCriterion("remove_pid not in", values, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidBetween(String value1, String value2) {
            addCriterion("remove_pid between", value1, value2, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePidNotBetween(String value1, String value2) {
            addCriterion("remove_pid not between", value1, value2, "removePid");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1IsNull() {
            addCriterion("remove_pdf1 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1IsNotNull() {
            addCriterion("remove_pdf1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1EqualTo(String value) {
            addCriterion("remove_pdf1 =", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1NotEqualTo(String value) {
            addCriterion("remove_pdf1 <>", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1GreaterThan(String value) {
            addCriterion("remove_pdf1 >", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf1 >=", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1LessThan(String value) {
            addCriterion("remove_pdf1 <", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf1 <=", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1Like(String value) {
            addCriterion("remove_pdf1 like", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1NotLike(String value) {
            addCriterion("remove_pdf1 not like", value, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1In(List<String> values) {
            addCriterion("remove_pdf1 in", values, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1NotIn(List<String> values) {
            addCriterion("remove_pdf1 not in", values, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1Between(String value1, String value2) {
            addCriterion("remove_pdf1 between", value1, value2, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf1NotBetween(String value1, String value2) {
            addCriterion("remove_pdf1 not between", value1, value2, "removePdf1");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2IsNull() {
            addCriterion("remove_pdf2 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2IsNotNull() {
            addCriterion("remove_pdf2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2EqualTo(String value) {
            addCriterion("remove_pdf2 =", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2NotEqualTo(String value) {
            addCriterion("remove_pdf2 <>", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2GreaterThan(String value) {
            addCriterion("remove_pdf2 >", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf2 >=", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2LessThan(String value) {
            addCriterion("remove_pdf2 <", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf2 <=", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2Like(String value) {
            addCriterion("remove_pdf2 like", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2NotLike(String value) {
            addCriterion("remove_pdf2 not like", value, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2In(List<String> values) {
            addCriterion("remove_pdf2 in", values, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2NotIn(List<String> values) {
            addCriterion("remove_pdf2 not in", values, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2Between(String value1, String value2) {
            addCriterion("remove_pdf2 between", value1, value2, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf2NotBetween(String value1, String value2) {
            addCriterion("remove_pdf2 not between", value1, value2, "removePdf2");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3IsNull() {
            addCriterion("remove_pdf3 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3IsNotNull() {
            addCriterion("remove_pdf3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3EqualTo(String value) {
            addCriterion("remove_pdf3 =", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3NotEqualTo(String value) {
            addCriterion("remove_pdf3 <>", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3GreaterThan(String value) {
            addCriterion("remove_pdf3 >", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf3 >=", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3LessThan(String value) {
            addCriterion("remove_pdf3 <", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf3 <=", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3Like(String value) {
            addCriterion("remove_pdf3 like", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3NotLike(String value) {
            addCriterion("remove_pdf3 not like", value, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3In(List<String> values) {
            addCriterion("remove_pdf3 in", values, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3NotIn(List<String> values) {
            addCriterion("remove_pdf3 not in", values, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3Between(String value1, String value2) {
            addCriterion("remove_pdf3 between", value1, value2, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf3NotBetween(String value1, String value2) {
            addCriterion("remove_pdf3 not between", value1, value2, "removePdf3");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4IsNull() {
            addCriterion("remove_pdf4 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4IsNotNull() {
            addCriterion("remove_pdf4 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4EqualTo(String value) {
            addCriterion("remove_pdf4 =", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4NotEqualTo(String value) {
            addCriterion("remove_pdf4 <>", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4GreaterThan(String value) {
            addCriterion("remove_pdf4 >", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf4 >=", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4LessThan(String value) {
            addCriterion("remove_pdf4 <", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf4 <=", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4Like(String value) {
            addCriterion("remove_pdf4 like", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4NotLike(String value) {
            addCriterion("remove_pdf4 not like", value, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4In(List<String> values) {
            addCriterion("remove_pdf4 in", values, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4NotIn(List<String> values) {
            addCriterion("remove_pdf4 not in", values, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4Between(String value1, String value2) {
            addCriterion("remove_pdf4 between", value1, value2, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf4NotBetween(String value1, String value2) {
            addCriterion("remove_pdf4 not between", value1, value2, "removePdf4");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5IsNull() {
            addCriterion("remove_pdf5 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5IsNotNull() {
            addCriterion("remove_pdf5 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5EqualTo(String value) {
            addCriterion("remove_pdf5 =", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5NotEqualTo(String value) {
            addCriterion("remove_pdf5 <>", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5GreaterThan(String value) {
            addCriterion("remove_pdf5 >", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf5 >=", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5LessThan(String value) {
            addCriterion("remove_pdf5 <", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf5 <=", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5Like(String value) {
            addCriterion("remove_pdf5 like", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5NotLike(String value) {
            addCriterion("remove_pdf5 not like", value, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5In(List<String> values) {
            addCriterion("remove_pdf5 in", values, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5NotIn(List<String> values) {
            addCriterion("remove_pdf5 not in", values, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5Between(String value1, String value2) {
            addCriterion("remove_pdf5 between", value1, value2, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf5NotBetween(String value1, String value2) {
            addCriterion("remove_pdf5 not between", value1, value2, "removePdf5");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6IsNull() {
            addCriterion("remove_pdf6 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6IsNotNull() {
            addCriterion("remove_pdf6 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6EqualTo(String value) {
            addCriterion("remove_pdf6 =", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6NotEqualTo(String value) {
            addCriterion("remove_pdf6 <>", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6GreaterThan(String value) {
            addCriterion("remove_pdf6 >", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf6 >=", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6LessThan(String value) {
            addCriterion("remove_pdf6 <", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf6 <=", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6Like(String value) {
            addCriterion("remove_pdf6 like", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6NotLike(String value) {
            addCriterion("remove_pdf6 not like", value, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6In(List<String> values) {
            addCriterion("remove_pdf6 in", values, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6NotIn(List<String> values) {
            addCriterion("remove_pdf6 not in", values, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6Between(String value1, String value2) {
            addCriterion("remove_pdf6 between", value1, value2, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf6NotBetween(String value1, String value2) {
            addCriterion("remove_pdf6 not between", value1, value2, "removePdf6");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7IsNull() {
            addCriterion("remove_pdf7 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7IsNotNull() {
            addCriterion("remove_pdf7 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7EqualTo(String value) {
            addCriterion("remove_pdf7 =", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7NotEqualTo(String value) {
            addCriterion("remove_pdf7 <>", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7GreaterThan(String value) {
            addCriterion("remove_pdf7 >", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf7 >=", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7LessThan(String value) {
            addCriterion("remove_pdf7 <", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf7 <=", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7Like(String value) {
            addCriterion("remove_pdf7 like", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7NotLike(String value) {
            addCriterion("remove_pdf7 not like", value, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7In(List<String> values) {
            addCriterion("remove_pdf7 in", values, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7NotIn(List<String> values) {
            addCriterion("remove_pdf7 not in", values, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7Between(String value1, String value2) {
            addCriterion("remove_pdf7 between", value1, value2, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf7NotBetween(String value1, String value2) {
            addCriterion("remove_pdf7 not between", value1, value2, "removePdf7");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8IsNull() {
            addCriterion("remove_pdf8 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8IsNotNull() {
            addCriterion("remove_pdf8 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8EqualTo(String value) {
            addCriterion("remove_pdf8 =", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8NotEqualTo(String value) {
            addCriterion("remove_pdf8 <>", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8GreaterThan(String value) {
            addCriterion("remove_pdf8 >", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf8 >=", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8LessThan(String value) {
            addCriterion("remove_pdf8 <", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf8 <=", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8Like(String value) {
            addCriterion("remove_pdf8 like", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8NotLike(String value) {
            addCriterion("remove_pdf8 not like", value, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8In(List<String> values) {
            addCriterion("remove_pdf8 in", values, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8NotIn(List<String> values) {
            addCriterion("remove_pdf8 not in", values, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8Between(String value1, String value2) {
            addCriterion("remove_pdf8 between", value1, value2, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf8NotBetween(String value1, String value2) {
            addCriterion("remove_pdf8 not between", value1, value2, "removePdf8");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9IsNull() {
            addCriterion("remove_pdf9 is null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9IsNotNull() {
            addCriterion("remove_pdf9 is not null");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9EqualTo(String value) {
            addCriterion("remove_pdf9 =", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9NotEqualTo(String value) {
            addCriterion("remove_pdf9 <>", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9GreaterThan(String value) {
            addCriterion("remove_pdf9 >", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9GreaterThanOrEqualTo(String value) {
            addCriterion("remove_pdf9 >=", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9LessThan(String value) {
            addCriterion("remove_pdf9 <", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9LessThanOrEqualTo(String value) {
            addCriterion("remove_pdf9 <=", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9Like(String value) {
            addCriterion("remove_pdf9 like", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9NotLike(String value) {
            addCriterion("remove_pdf9 not like", value, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9In(List<String> values) {
            addCriterion("remove_pdf9 in", values, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9NotIn(List<String> values) {
            addCriterion("remove_pdf9 not in", values, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9Between(String value1, String value2) {
            addCriterion("remove_pdf9 between", value1, value2, "removePdf9");
            return (Criteria) this;
        }

        public Criteria andRemovePdf9NotBetween(String value1, String value2) {
            addCriterion("remove_pdf9 not between", value1, value2, "removePdf9");
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