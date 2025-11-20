package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PoliceNetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoliceNetExample() {
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

        public Criteria andNetNameIsNull() {
            addCriterion("net_name is null");
            return (Criteria) this;
        }

        public Criteria andNetNameIsNotNull() {
            addCriterion("net_name is not null");
            return (Criteria) this;
        }

        public Criteria andNetNameEqualTo(String value) {
            addCriterion("net_name =", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameNotEqualTo(String value) {
            addCriterion("net_name <>", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameGreaterThan(String value) {
            addCriterion("net_name >", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameGreaterThanOrEqualTo(String value) {
            addCriterion("net_name >=", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameLessThan(String value) {
            addCriterion("net_name <", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameLessThanOrEqualTo(String value) {
            addCriterion("net_name <=", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameLike(String value) {
            addCriterion("net_name like", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameNotLike(String value) {
            addCriterion("net_name not like", value, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameIn(List<String> values) {
            addCriterion("net_name in", values, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameNotIn(List<String> values) {
            addCriterion("net_name not in", values, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameBetween(String value1, String value2) {
            addCriterion("net_name between", value1, value2, "netName");
            return (Criteria) this;
        }

        public Criteria andNetNameNotBetween(String value1, String value2) {
            addCriterion("net_name not between", value1, value2, "netName");
            return (Criteria) this;
        }

        public Criteria andNetDepIsNull() {
            addCriterion("net_dep is null");
            return (Criteria) this;
        }

        public Criteria andNetDepIsNotNull() {
            addCriterion("net_dep is not null");
            return (Criteria) this;
        }

        public Criteria andNetDepEqualTo(String value) {
            addCriterion("net_dep =", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepNotEqualTo(String value) {
            addCriterion("net_dep <>", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepGreaterThan(String value) {
            addCriterion("net_dep >", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepGreaterThanOrEqualTo(String value) {
            addCriterion("net_dep >=", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepLessThan(String value) {
            addCriterion("net_dep <", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepLessThanOrEqualTo(String value) {
            addCriterion("net_dep <=", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepLike(String value) {
            addCriterion("net_dep like", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepNotLike(String value) {
            addCriterion("net_dep not like", value, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepIn(List<String> values) {
            addCriterion("net_dep in", values, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepNotIn(List<String> values) {
            addCriterion("net_dep not in", values, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepBetween(String value1, String value2) {
            addCriterion("net_dep between", value1, value2, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetDepNotBetween(String value1, String value2) {
            addCriterion("net_dep not between", value1, value2, "netDep");
            return (Criteria) this;
        }

        public Criteria andNetPolygenIsNull() {
            addCriterion("net_polygen is null");
            return (Criteria) this;
        }

        public Criteria andNetPolygenIsNotNull() {
            addCriterion("net_polygen is not null");
            return (Criteria) this;
        }

        public Criteria andNetPolygenEqualTo(String value) {
            addCriterion("net_polygen =", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenNotEqualTo(String value) {
            addCriterion("net_polygen <>", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenGreaterThan(String value) {
            addCriterion("net_polygen >", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenGreaterThanOrEqualTo(String value) {
            addCriterion("net_polygen >=", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenLessThan(String value) {
            addCriterion("net_polygen <", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenLessThanOrEqualTo(String value) {
            addCriterion("net_polygen <=", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenLike(String value) {
            addCriterion("net_polygen like", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenNotLike(String value) {
            addCriterion("net_polygen not like", value, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenIn(List<String> values) {
            addCriterion("net_polygen in", values, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenNotIn(List<String> values) {
            addCriterion("net_polygen not in", values, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenBetween(String value1, String value2) {
            addCriterion("net_polygen between", value1, value2, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetPolygenNotBetween(String value1, String value2) {
            addCriterion("net_polygen not between", value1, value2, "netPolygen");
            return (Criteria) this;
        }

        public Criteria andNetColorIsNull() {
            addCriterion("net_color is null");
            return (Criteria) this;
        }

        public Criteria andNetColorIsNotNull() {
            addCriterion("net_color is not null");
            return (Criteria) this;
        }

        public Criteria andNetColorEqualTo(String value) {
            addCriterion("net_color =", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorNotEqualTo(String value) {
            addCriterion("net_color <>", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorGreaterThan(String value) {
            addCriterion("net_color >", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorGreaterThanOrEqualTo(String value) {
            addCriterion("net_color >=", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorLessThan(String value) {
            addCriterion("net_color <", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorLessThanOrEqualTo(String value) {
            addCriterion("net_color <=", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorLike(String value) {
            addCriterion("net_color like", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorNotLike(String value) {
            addCriterion("net_color not like", value, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorIn(List<String> values) {
            addCriterion("net_color in", values, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorNotIn(List<String> values) {
            addCriterion("net_color not in", values, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorBetween(String value1, String value2) {
            addCriterion("net_color between", value1, value2, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetColorNotBetween(String value1, String value2) {
            addCriterion("net_color not between", value1, value2, "netColor");
            return (Criteria) this;
        }

        public Criteria andNetCenterIsNull() {
            addCriterion("net_center is null");
            return (Criteria) this;
        }

        public Criteria andNetCenterIsNotNull() {
            addCriterion("net_center is not null");
            return (Criteria) this;
        }

        public Criteria andNetCenterEqualTo(String value) {
            addCriterion("net_center =", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterNotEqualTo(String value) {
            addCriterion("net_center <>", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterGreaterThan(String value) {
            addCriterion("net_center >", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterGreaterThanOrEqualTo(String value) {
            addCriterion("net_center >=", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterLessThan(String value) {
            addCriterion("net_center <", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterLessThanOrEqualTo(String value) {
            addCriterion("net_center <=", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterLike(String value) {
            addCriterion("net_center like", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterNotLike(String value) {
            addCriterion("net_center not like", value, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterIn(List<String> values) {
            addCriterion("net_center in", values, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterNotIn(List<String> values) {
            addCriterion("net_center not in", values, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterBetween(String value1, String value2) {
            addCriterion("net_center between", value1, value2, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetCenterNotBetween(String value1, String value2) {
            addCriterion("net_center not between", value1, value2, "netCenter");
            return (Criteria) this;
        }

        public Criteria andNetTimeIsNull() {
            addCriterion("net_time is null");
            return (Criteria) this;
        }

        public Criteria andNetTimeIsNotNull() {
            addCriterion("net_time is not null");
            return (Criteria) this;
        }

        public Criteria andNetTimeEqualTo(String value) {
            addCriterion("net_time =", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeNotEqualTo(String value) {
            addCriterion("net_time <>", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeGreaterThan(String value) {
            addCriterion("net_time >", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeGreaterThanOrEqualTo(String value) {
            addCriterion("net_time >=", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeLessThan(String value) {
            addCriterion("net_time <", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeLessThanOrEqualTo(String value) {
            addCriterion("net_time <=", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeLike(String value) {
            addCriterion("net_time like", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeNotLike(String value) {
            addCriterion("net_time not like", value, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeIn(List<String> values) {
            addCriterion("net_time in", values, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeNotIn(List<String> values) {
            addCriterion("net_time not in", values, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeBetween(String value1, String value2) {
            addCriterion("net_time between", value1, value2, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetTimeNotBetween(String value1, String value2) {
            addCriterion("net_time not between", value1, value2, "netTime");
            return (Criteria) this;
        }

        public Criteria andNetLevelIsNull() {
            addCriterion("net_level is null");
            return (Criteria) this;
        }

        public Criteria andNetLevelIsNotNull() {
            addCriterion("net_level is not null");
            return (Criteria) this;
        }

        public Criteria andNetLevelEqualTo(String value) {
            addCriterion("net_level =", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelNotEqualTo(String value) {
            addCriterion("net_level <>", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelGreaterThan(String value) {
            addCriterion("net_level >", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelGreaterThanOrEqualTo(String value) {
            addCriterion("net_level >=", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelLessThan(String value) {
            addCriterion("net_level <", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelLessThanOrEqualTo(String value) {
            addCriterion("net_level <=", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelLike(String value) {
            addCriterion("net_level like", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelNotLike(String value) {
            addCriterion("net_level not like", value, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelIn(List<String> values) {
            addCriterion("net_level in", values, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelNotIn(List<String> values) {
            addCriterion("net_level not in", values, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelBetween(String value1, String value2) {
            addCriterion("net_level between", value1, value2, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetLevelNotBetween(String value1, String value2) {
            addCriterion("net_level not between", value1, value2, "netLevel");
            return (Criteria) this;
        }

        public Criteria andNetAreaIsNull() {
            addCriterion("net_area is null");
            return (Criteria) this;
        }

        public Criteria andNetAreaIsNotNull() {
            addCriterion("net_area is not null");
            return (Criteria) this;
        }

        public Criteria andNetAreaEqualTo(String value) {
            addCriterion("net_area =", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaNotEqualTo(String value) {
            addCriterion("net_area <>", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaGreaterThan(String value) {
            addCriterion("net_area >", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaGreaterThanOrEqualTo(String value) {
            addCriterion("net_area >=", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaLessThan(String value) {
            addCriterion("net_area <", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaLessThanOrEqualTo(String value) {
            addCriterion("net_area <=", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaLike(String value) {
            addCriterion("net_area like", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaNotLike(String value) {
            addCriterion("net_area not like", value, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaIn(List<String> values) {
            addCriterion("net_area in", values, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaNotIn(List<String> values) {
            addCriterion("net_area not in", values, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaBetween(String value1, String value2) {
            addCriterion("net_area between", value1, value2, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetAreaNotBetween(String value1, String value2) {
            addCriterion("net_area not between", value1, value2, "netArea");
            return (Criteria) this;
        }

        public Criteria andNetPeopleIsNull() {
            addCriterion("net_people is null");
            return (Criteria) this;
        }

        public Criteria andNetPeopleIsNotNull() {
            addCriterion("net_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetPeopleEqualTo(String value) {
            addCriterion("net_people =", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleNotEqualTo(String value) {
            addCriterion("net_people <>", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleGreaterThan(String value) {
            addCriterion("net_people >", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_people >=", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleLessThan(String value) {
            addCriterion("net_people <", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_people <=", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleLike(String value) {
            addCriterion("net_people like", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleNotLike(String value) {
            addCriterion("net_people not like", value, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleIn(List<String> values) {
            addCriterion("net_people in", values, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleNotIn(List<String> values) {
            addCriterion("net_people not in", values, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleBetween(String value1, String value2) {
            addCriterion("net_people between", value1, value2, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetPeopleNotBetween(String value1, String value2) {
            addCriterion("net_people not between", value1, value2, "netPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleIsNull() {
            addCriterion("net_key_people is null");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleIsNotNull() {
            addCriterion("net_key_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleEqualTo(String value) {
            addCriterion("net_key_people =", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleNotEqualTo(String value) {
            addCriterion("net_key_people <>", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleGreaterThan(String value) {
            addCriterion("net_key_people >", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_key_people >=", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleLessThan(String value) {
            addCriterion("net_key_people <", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_key_people <=", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleLike(String value) {
            addCriterion("net_key_people like", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleNotLike(String value) {
            addCriterion("net_key_people not like", value, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleIn(List<String> values) {
            addCriterion("net_key_people in", values, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleNotIn(List<String> values) {
            addCriterion("net_key_people not in", values, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleBetween(String value1, String value2) {
            addCriterion("net_key_people between", value1, value2, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetKeyPeopleNotBetween(String value1, String value2) {
            addCriterion("net_key_people not between", value1, value2, "netKeyPeople");
            return (Criteria) this;
        }

        public Criteria andNetNoteIsNull() {
            addCriterion("net_note is null");
            return (Criteria) this;
        }

        public Criteria andNetNoteIsNotNull() {
            addCriterion("net_note is not null");
            return (Criteria) this;
        }

        public Criteria andNetNoteEqualTo(String value) {
            addCriterion("net_note =", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotEqualTo(String value) {
            addCriterion("net_note <>", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteGreaterThan(String value) {
            addCriterion("net_note >", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteGreaterThanOrEqualTo(String value) {
            addCriterion("net_note >=", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLessThan(String value) {
            addCriterion("net_note <", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLessThanOrEqualTo(String value) {
            addCriterion("net_note <=", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLike(String value) {
            addCriterion("net_note like", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotLike(String value) {
            addCriterion("net_note not like", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteIn(List<String> values) {
            addCriterion("net_note in", values, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotIn(List<String> values) {
            addCriterion("net_note not in", values, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteBetween(String value1, String value2) {
            addCriterion("net_note between", value1, value2, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotBetween(String value1, String value2) {
            addCriterion("net_note not between", value1, value2, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareIsNull() {
            addCriterion("net_duty_care is null");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareIsNotNull() {
            addCriterion("net_duty_care is not null");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareEqualTo(String value) {
            addCriterion("net_duty_care =", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareNotEqualTo(String value) {
            addCriterion("net_duty_care <>", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareGreaterThan(String value) {
            addCriterion("net_duty_care >", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareGreaterThanOrEqualTo(String value) {
            addCriterion("net_duty_care >=", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareLessThan(String value) {
            addCriterion("net_duty_care <", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareLessThanOrEqualTo(String value) {
            addCriterion("net_duty_care <=", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareLike(String value) {
            addCriterion("net_duty_care like", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareNotLike(String value) {
            addCriterion("net_duty_care not like", value, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareIn(List<String> values) {
            addCriterion("net_duty_care in", values, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareNotIn(List<String> values) {
            addCriterion("net_duty_care not in", values, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareBetween(String value1, String value2) {
            addCriterion("net_duty_care between", value1, value2, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetDutyCareNotBetween(String value1, String value2) {
            addCriterion("net_duty_care not between", value1, value2, "netDutyCare");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteIsNull() {
            addCriterion("net_care_note is null");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteIsNotNull() {
            addCriterion("net_care_note is not null");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteEqualTo(String value) {
            addCriterion("net_care_note =", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteNotEqualTo(String value) {
            addCriterion("net_care_note <>", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteGreaterThan(String value) {
            addCriterion("net_care_note >", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteGreaterThanOrEqualTo(String value) {
            addCriterion("net_care_note >=", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteLessThan(String value) {
            addCriterion("net_care_note <", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteLessThanOrEqualTo(String value) {
            addCriterion("net_care_note <=", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteLike(String value) {
            addCriterion("net_care_note like", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteNotLike(String value) {
            addCriterion("net_care_note not like", value, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteIn(List<String> values) {
            addCriterion("net_care_note in", values, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteNotIn(List<String> values) {
            addCriterion("net_care_note not in", values, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteBetween(String value1, String value2) {
            addCriterion("net_care_note between", value1, value2, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetCareNoteNotBetween(String value1, String value2) {
            addCriterion("net_care_note not between", value1, value2, "netCareNote");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsIsNull() {
            addCriterion("net_duty_goods is null");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsIsNotNull() {
            addCriterion("net_duty_goods is not null");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsEqualTo(String value) {
            addCriterion("net_duty_goods =", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsNotEqualTo(String value) {
            addCriterion("net_duty_goods <>", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsGreaterThan(String value) {
            addCriterion("net_duty_goods >", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("net_duty_goods >=", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsLessThan(String value) {
            addCriterion("net_duty_goods <", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsLessThanOrEqualTo(String value) {
            addCriterion("net_duty_goods <=", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsLike(String value) {
            addCriterion("net_duty_goods like", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsNotLike(String value) {
            addCriterion("net_duty_goods not like", value, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsIn(List<String> values) {
            addCriterion("net_duty_goods in", values, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsNotIn(List<String> values) {
            addCriterion("net_duty_goods not in", values, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsBetween(String value1, String value2) {
            addCriterion("net_duty_goods between", value1, value2, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetDutyGoodsNotBetween(String value1, String value2) {
            addCriterion("net_duty_goods not between", value1, value2, "netDutyGoods");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteIsNull() {
            addCriterion("net_goods_note is null");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteIsNotNull() {
            addCriterion("net_goods_note is not null");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteEqualTo(String value) {
            addCriterion("net_goods_note =", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteNotEqualTo(String value) {
            addCriterion("net_goods_note <>", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteGreaterThan(String value) {
            addCriterion("net_goods_note >", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteGreaterThanOrEqualTo(String value) {
            addCriterion("net_goods_note >=", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteLessThan(String value) {
            addCriterion("net_goods_note <", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteLessThanOrEqualTo(String value) {
            addCriterion("net_goods_note <=", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteLike(String value) {
            addCriterion("net_goods_note like", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteNotLike(String value) {
            addCriterion("net_goods_note not like", value, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteIn(List<String> values) {
            addCriterion("net_goods_note in", values, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteNotIn(List<String> values) {
            addCriterion("net_goods_note not in", values, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteBetween(String value1, String value2) {
            addCriterion("net_goods_note between", value1, value2, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andNetGoodsNoteNotBetween(String value1, String value2) {
            addCriterion("net_goods_note not between", value1, value2, "netGoodsNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteIsNull() {
            addCriterion("other_note is null");
            return (Criteria) this;
        }

        public Criteria andOtherNoteIsNotNull() {
            addCriterion("other_note is not null");
            return (Criteria) this;
        }

        public Criteria andOtherNoteEqualTo(String value) {
            addCriterion("other_note =", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteNotEqualTo(String value) {
            addCriterion("other_note <>", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteGreaterThan(String value) {
            addCriterion("other_note >", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteGreaterThanOrEqualTo(String value) {
            addCriterion("other_note >=", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteLessThan(String value) {
            addCriterion("other_note <", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteLessThanOrEqualTo(String value) {
            addCriterion("other_note <=", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteLike(String value) {
            addCriterion("other_note like", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteNotLike(String value) {
            addCriterion("other_note not like", value, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteIn(List<String> values) {
            addCriterion("other_note in", values, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteNotIn(List<String> values) {
            addCriterion("other_note not in", values, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteBetween(String value1, String value2) {
            addCriterion("other_note between", value1, value2, "otherNote");
            return (Criteria) this;
        }

        public Criteria andOtherNoteNotBetween(String value1, String value2) {
            addCriterion("other_note not between", value1, value2, "otherNote");
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