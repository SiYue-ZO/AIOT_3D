package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class BuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andZdhIsNull() {
            addCriterion("zdh is null");
            return (Criteria) this;
        }

        public Criteria andZdhIsNotNull() {
            addCriterion("zdh is not null");
            return (Criteria) this;
        }

        public Criteria andZdhEqualTo(String value) {
            addCriterion("zdh =", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhNotEqualTo(String value) {
            addCriterion("zdh <>", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhGreaterThan(String value) {
            addCriterion("zdh >", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhGreaterThanOrEqualTo(String value) {
            addCriterion("zdh >=", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhLessThan(String value) {
            addCriterion("zdh <", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhLessThanOrEqualTo(String value) {
            addCriterion("zdh <=", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhLike(String value) {
            addCriterion("zdh like", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhNotLike(String value) {
            addCriterion("zdh not like", value, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhIn(List<String> values) {
            addCriterion("zdh in", values, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhNotIn(List<String> values) {
            addCriterion("zdh not in", values, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhBetween(String value1, String value2) {
            addCriterion("zdh between", value1, value2, "zdh");
            return (Criteria) this;
        }

        public Criteria andZdhNotBetween(String value1, String value2) {
            addCriterion("zdh not between", value1, value2, "zdh");
            return (Criteria) this;
        }

        public Criteria andTdxzIsNull() {
            addCriterion("tdxz is null");
            return (Criteria) this;
        }

        public Criteria andTdxzIsNotNull() {
            addCriterion("tdxz is not null");
            return (Criteria) this;
        }

        public Criteria andTdxzEqualTo(String value) {
            addCriterion("tdxz =", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzNotEqualTo(String value) {
            addCriterion("tdxz <>", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzGreaterThan(String value) {
            addCriterion("tdxz >", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzGreaterThanOrEqualTo(String value) {
            addCriterion("tdxz >=", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzLessThan(String value) {
            addCriterion("tdxz <", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzLessThanOrEqualTo(String value) {
            addCriterion("tdxz <=", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzLike(String value) {
            addCriterion("tdxz like", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzNotLike(String value) {
            addCriterion("tdxz not like", value, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzIn(List<String> values) {
            addCriterion("tdxz in", values, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzNotIn(List<String> values) {
            addCriterion("tdxz not in", values, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzBetween(String value1, String value2) {
            addCriterion("tdxz between", value1, value2, "tdxz");
            return (Criteria) this;
        }

        public Criteria andTdxzNotBetween(String value1, String value2) {
            addCriterion("tdxz not between", value1, value2, "tdxz");
            return (Criteria) this;
        }

        public Criteria andYxgsIsNull() {
            addCriterion("yxgs is null");
            return (Criteria) this;
        }

        public Criteria andYxgsIsNotNull() {
            addCriterion("yxgs is not null");
            return (Criteria) this;
        }

        public Criteria andYxgsEqualTo(String value) {
            addCriterion("yxgs =", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsNotEqualTo(String value) {
            addCriterion("yxgs <>", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsGreaterThan(String value) {
            addCriterion("yxgs >", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsGreaterThanOrEqualTo(String value) {
            addCriterion("yxgs >=", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsLessThan(String value) {
            addCriterion("yxgs <", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsLessThanOrEqualTo(String value) {
            addCriterion("yxgs <=", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsLike(String value) {
            addCriterion("yxgs like", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsNotLike(String value) {
            addCriterion("yxgs not like", value, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsIn(List<String> values) {
            addCriterion("yxgs in", values, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsNotIn(List<String> values) {
            addCriterion("yxgs not in", values, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsBetween(String value1, String value2) {
            addCriterion("yxgs between", value1, value2, "yxgs");
            return (Criteria) this;
        }

        public Criteria andYxgsNotBetween(String value1, String value2) {
            addCriterion("yxgs not between", value1, value2, "yxgs");
            return (Criteria) this;
        }

        public Criteria andJzzdmjIsNull() {
            addCriterion("jzzdmj is null");
            return (Criteria) this;
        }

        public Criteria andJzzdmjIsNotNull() {
            addCriterion("jzzdmj is not null");
            return (Criteria) this;
        }

        public Criteria andJzzdmjEqualTo(String value) {
            addCriterion("jzzdmj =", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjNotEqualTo(String value) {
            addCriterion("jzzdmj <>", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjGreaterThan(String value) {
            addCriterion("jzzdmj >", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjGreaterThanOrEqualTo(String value) {
            addCriterion("jzzdmj >=", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjLessThan(String value) {
            addCriterion("jzzdmj <", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjLessThanOrEqualTo(String value) {
            addCriterion("jzzdmj <=", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjLike(String value) {
            addCriterion("jzzdmj like", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjNotLike(String value) {
            addCriterion("jzzdmj not like", value, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjIn(List<String> values) {
            addCriterion("jzzdmj in", values, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjNotIn(List<String> values) {
            addCriterion("jzzdmj not in", values, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjBetween(String value1, String value2) {
            addCriterion("jzzdmj between", value1, value2, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andJzzdmjNotBetween(String value1, String value2) {
            addCriterion("jzzdmj not between", value1, value2, "jzzdmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjIsNull() {
            addCriterion("sjjzmj is null");
            return (Criteria) this;
        }

        public Criteria andSjjzmjIsNotNull() {
            addCriterion("sjjzmj is not null");
            return (Criteria) this;
        }

        public Criteria andSjjzmjEqualTo(String value) {
            addCriterion("sjjzmj =", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjNotEqualTo(String value) {
            addCriterion("sjjzmj <>", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjGreaterThan(String value) {
            addCriterion("sjjzmj >", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjGreaterThanOrEqualTo(String value) {
            addCriterion("sjjzmj >=", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjLessThan(String value) {
            addCriterion("sjjzmj <", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjLessThanOrEqualTo(String value) {
            addCriterion("sjjzmj <=", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjLike(String value) {
            addCriterion("sjjzmj like", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjNotLike(String value) {
            addCriterion("sjjzmj not like", value, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjIn(List<String> values) {
            addCriterion("sjjzmj in", values, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjNotIn(List<String> values) {
            addCriterion("sjjzmj not in", values, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjBetween(String value1, String value2) {
            addCriterion("sjjzmj between", value1, value2, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andSjjzmjNotBetween(String value1, String value2) {
            addCriterion("sjjzmj not between", value1, value2, "sjjzmj");
            return (Criteria) this;
        }

        public Criteria andFwjgIsNull() {
            addCriterion("fwjg is null");
            return (Criteria) this;
        }

        public Criteria andFwjgIsNotNull() {
            addCriterion("fwjg is not null");
            return (Criteria) this;
        }

        public Criteria andFwjgEqualTo(String value) {
            addCriterion("fwjg =", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgNotEqualTo(String value) {
            addCriterion("fwjg <>", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgGreaterThan(String value) {
            addCriterion("fwjg >", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgGreaterThanOrEqualTo(String value) {
            addCriterion("fwjg >=", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgLessThan(String value) {
            addCriterion("fwjg <", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgLessThanOrEqualTo(String value) {
            addCriterion("fwjg <=", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgLike(String value) {
            addCriterion("fwjg like", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgNotLike(String value) {
            addCriterion("fwjg not like", value, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgIn(List<String> values) {
            addCriterion("fwjg in", values, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgNotIn(List<String> values) {
            addCriterion("fwjg not in", values, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgBetween(String value1, String value2) {
            addCriterion("fwjg between", value1, value2, "fwjg");
            return (Criteria) this;
        }

        public Criteria andFwjgNotBetween(String value1, String value2) {
            addCriterion("fwjg not between", value1, value2, "fwjg");
            return (Criteria) this;
        }

        public Criteria andTypeRealIsNull() {
            addCriterion("type_real is null");
            return (Criteria) this;
        }

        public Criteria andTypeRealIsNotNull() {
            addCriterion("type_real is not null");
            return (Criteria) this;
        }

        public Criteria andTypeRealEqualTo(String value) {
            addCriterion("type_real =", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealNotEqualTo(String value) {
            addCriterion("type_real <>", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealGreaterThan(String value) {
            addCriterion("type_real >", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealGreaterThanOrEqualTo(String value) {
            addCriterion("type_real >=", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealLessThan(String value) {
            addCriterion("type_real <", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealLessThanOrEqualTo(String value) {
            addCriterion("type_real <=", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealLike(String value) {
            addCriterion("type_real like", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealNotLike(String value) {
            addCriterion("type_real not like", value, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealIn(List<String> values) {
            addCriterion("type_real in", values, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealNotIn(List<String> values) {
            addCriterion("type_real not in", values, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealBetween(String value1, String value2) {
            addCriterion("type_real between", value1, value2, "typeReal");
            return (Criteria) this;
        }

        public Criteria andTypeRealNotBetween(String value1, String value2) {
            addCriterion("type_real not between", value1, value2, "typeReal");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptIsNull() {
            addCriterion("area_accept is null");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptIsNotNull() {
            addCriterion("area_accept is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptEqualTo(String value) {
            addCriterion("area_accept =", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptNotEqualTo(String value) {
            addCriterion("area_accept <>", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptGreaterThan(String value) {
            addCriterion("area_accept >", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("area_accept >=", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptLessThan(String value) {
            addCriterion("area_accept <", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptLessThanOrEqualTo(String value) {
            addCriterion("area_accept <=", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptLike(String value) {
            addCriterion("area_accept like", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptNotLike(String value) {
            addCriterion("area_accept not like", value, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptIn(List<String> values) {
            addCriterion("area_accept in", values, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptNotIn(List<String> values) {
            addCriterion("area_accept not in", values, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptBetween(String value1, String value2) {
            addCriterion("area_accept between", value1, value2, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andAreaAcceptNotBetween(String value1, String value2) {
            addCriterion("area_accept not between", value1, value2, "areaAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptIsNull() {
            addCriterion("type_accept is null");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptIsNotNull() {
            addCriterion("type_accept is not null");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptEqualTo(String value) {
            addCriterion("type_accept =", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptNotEqualTo(String value) {
            addCriterion("type_accept <>", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptGreaterThan(String value) {
            addCriterion("type_accept >", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("type_accept >=", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptLessThan(String value) {
            addCriterion("type_accept <", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptLessThanOrEqualTo(String value) {
            addCriterion("type_accept <=", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptLike(String value) {
            addCriterion("type_accept like", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptNotLike(String value) {
            addCriterion("type_accept not like", value, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptIn(List<String> values) {
            addCriterion("type_accept in", values, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptNotIn(List<String> values) {
            addCriterion("type_accept not in", values, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptBetween(String value1, String value2) {
            addCriterion("type_accept between", value1, value2, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andTypeAcceptNotBetween(String value1, String value2) {
            addCriterion("type_accept not between", value1, value2, "typeAccept");
            return (Criteria) this;
        }

        public Criteria andAcceptNumIsNull() {
            addCriterion("accept_num is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumIsNotNull() {
            addCriterion("accept_num is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumEqualTo(String value) {
            addCriterion("accept_num =", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumNotEqualTo(String value) {
            addCriterion("accept_num <>", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumGreaterThan(String value) {
            addCriterion("accept_num >", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumGreaterThanOrEqualTo(String value) {
            addCriterion("accept_num >=", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumLessThan(String value) {
            addCriterion("accept_num <", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumLessThanOrEqualTo(String value) {
            addCriterion("accept_num <=", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumLike(String value) {
            addCriterion("accept_num like", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumNotLike(String value) {
            addCriterion("accept_num not like", value, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumIn(List<String> values) {
            addCriterion("accept_num in", values, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumNotIn(List<String> values) {
            addCriterion("accept_num not in", values, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumBetween(String value1, String value2) {
            addCriterion("accept_num between", value1, value2, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andAcceptNumNotBetween(String value1, String value2) {
            addCriterion("accept_num not between", value1, value2, "acceptNum");
            return (Criteria) this;
        }

        public Criteria andFczhIsNull() {
            addCriterion("fczh is null");
            return (Criteria) this;
        }

        public Criteria andFczhIsNotNull() {
            addCriterion("fczh is not null");
            return (Criteria) this;
        }

        public Criteria andFczhEqualTo(String value) {
            addCriterion("fczh =", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhNotEqualTo(String value) {
            addCriterion("fczh <>", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhGreaterThan(String value) {
            addCriterion("fczh >", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhGreaterThanOrEqualTo(String value) {
            addCriterion("fczh >=", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhLessThan(String value) {
            addCriterion("fczh <", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhLessThanOrEqualTo(String value) {
            addCriterion("fczh <=", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhLike(String value) {
            addCriterion("fczh like", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhNotLike(String value) {
            addCriterion("fczh not like", value, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhIn(List<String> values) {
            addCriterion("fczh in", values, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhNotIn(List<String> values) {
            addCriterion("fczh not in", values, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhBetween(String value1, String value2) {
            addCriterion("fczh between", value1, value2, "fczh");
            return (Criteria) this;
        }

        public Criteria andFczhNotBetween(String value1, String value2) {
            addCriterion("fczh not between", value1, value2, "fczh");
            return (Criteria) this;
        }

        public Criteria andAreaRecordIsNull() {
            addCriterion("area_record is null");
            return (Criteria) this;
        }

        public Criteria andAreaRecordIsNotNull() {
            addCriterion("area_record is not null");
            return (Criteria) this;
        }

        public Criteria andAreaRecordEqualTo(String value) {
            addCriterion("area_record =", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordNotEqualTo(String value) {
            addCriterion("area_record <>", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordGreaterThan(String value) {
            addCriterion("area_record >", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordGreaterThanOrEqualTo(String value) {
            addCriterion("area_record >=", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordLessThan(String value) {
            addCriterion("area_record <", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordLessThanOrEqualTo(String value) {
            addCriterion("area_record <=", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordLike(String value) {
            addCriterion("area_record like", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordNotLike(String value) {
            addCriterion("area_record not like", value, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordIn(List<String> values) {
            addCriterion("area_record in", values, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordNotIn(List<String> values) {
            addCriterion("area_record not in", values, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordBetween(String value1, String value2) {
            addCriterion("area_record between", value1, value2, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaRecordNotBetween(String value1, String value2) {
            addCriterion("area_record not between", value1, value2, "areaRecord");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingIsNull() {
            addCriterion("area_building is null");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingIsNotNull() {
            addCriterion("area_building is not null");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingEqualTo(String value) {
            addCriterion("area_building =", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingNotEqualTo(String value) {
            addCriterion("area_building <>", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingGreaterThan(String value) {
            addCriterion("area_building >", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingGreaterThanOrEqualTo(String value) {
            addCriterion("area_building >=", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingLessThan(String value) {
            addCriterion("area_building <", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingLessThanOrEqualTo(String value) {
            addCriterion("area_building <=", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingLike(String value) {
            addCriterion("area_building like", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingNotLike(String value) {
            addCriterion("area_building not like", value, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingIn(List<String> values) {
            addCriterion("area_building in", values, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingNotIn(List<String> values) {
            addCriterion("area_building not in", values, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingBetween(String value1, String value2) {
            addCriterion("area_building between", value1, value2, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andAreaBuildingNotBetween(String value1, String value2) {
            addCriterion("area_building not between", value1, value2, "areaBuilding");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("plan_type like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("plan_type not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andDbnumIsNull() {
            addCriterion("dbnum is null");
            return (Criteria) this;
        }

        public Criteria andDbnumIsNotNull() {
            addCriterion("dbnum is not null");
            return (Criteria) this;
        }

        public Criteria andDbnumEqualTo(String value) {
            addCriterion("dbnum =", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumNotEqualTo(String value) {
            addCriterion("dbnum <>", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumGreaterThan(String value) {
            addCriterion("dbnum >", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumGreaterThanOrEqualTo(String value) {
            addCriterion("dbnum >=", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumLessThan(String value) {
            addCriterion("dbnum <", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumLessThanOrEqualTo(String value) {
            addCriterion("dbnum <=", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumLike(String value) {
            addCriterion("dbnum like", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumNotLike(String value) {
            addCriterion("dbnum not like", value, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumIn(List<String> values) {
            addCriterion("dbnum in", values, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumNotIn(List<String> values) {
            addCriterion("dbnum not in", values, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumBetween(String value1, String value2) {
            addCriterion("dbnum between", value1, value2, "dbnum");
            return (Criteria) this;
        }

        public Criteria andDbnumNotBetween(String value1, String value2) {
            addCriterion("dbnum not between", value1, value2, "dbnum");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNull() {
            addCriterion("coordinates is null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNotNull() {
            addCriterion("coordinates is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesEqualTo(String value) {
            addCriterion("coordinates =", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotEqualTo(String value) {
            addCriterion("coordinates <>", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThan(String value) {
            addCriterion("coordinates >", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThanOrEqualTo(String value) {
            addCriterion("coordinates >=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThan(String value) {
            addCriterion("coordinates <", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThanOrEqualTo(String value) {
            addCriterion("coordinates <=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLike(String value) {
            addCriterion("coordinates like", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotLike(String value) {
            addCriterion("coordinates not like", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIn(List<String> values) {
            addCriterion("coordinates in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotIn(List<String> values) {
            addCriterion("coordinates not in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesBetween(String value1, String value2) {
            addCriterion("coordinates between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotBetween(String value1, String value2) {
            addCriterion("coordinates not between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andFwcsIsNull() {
            addCriterion("fwcs is null");
            return (Criteria) this;
        }

        public Criteria andFwcsIsNotNull() {
            addCriterion("fwcs is not null");
            return (Criteria) this;
        }

        public Criteria andFwcsEqualTo(String value) {
            addCriterion("fwcs =", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsNotEqualTo(String value) {
            addCriterion("fwcs <>", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsGreaterThan(String value) {
            addCriterion("fwcs >", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsGreaterThanOrEqualTo(String value) {
            addCriterion("fwcs >=", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsLessThan(String value) {
            addCriterion("fwcs <", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsLessThanOrEqualTo(String value) {
            addCriterion("fwcs <=", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsLike(String value) {
            addCriterion("fwcs like", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsNotLike(String value) {
            addCriterion("fwcs not like", value, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsIn(List<String> values) {
            addCriterion("fwcs in", values, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsNotIn(List<String> values) {
            addCriterion("fwcs not in", values, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsBetween(String value1, String value2) {
            addCriterion("fwcs between", value1, value2, "fwcs");
            return (Criteria) this;
        }

        public Criteria andFwcsNotBetween(String value1, String value2) {
            addCriterion("fwcs not between", value1, value2, "fwcs");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andBuildingImgIsNull() {
            addCriterion("building_img is null");
            return (Criteria) this;
        }

        public Criteria andBuildingImgIsNotNull() {
            addCriterion("building_img is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingImgEqualTo(String value) {
            addCriterion("building_img =", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgNotEqualTo(String value) {
            addCriterion("building_img <>", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgGreaterThan(String value) {
            addCriterion("building_img >", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgGreaterThanOrEqualTo(String value) {
            addCriterion("building_img >=", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgLessThan(String value) {
            addCriterion("building_img <", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgLessThanOrEqualTo(String value) {
            addCriterion("building_img <=", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgLike(String value) {
            addCriterion("building_img like", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgNotLike(String value) {
            addCriterion("building_img not like", value, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgIn(List<String> values) {
            addCriterion("building_img in", values, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgNotIn(List<String> values) {
            addCriterion("building_img not in", values, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgBetween(String value1, String value2) {
            addCriterion("building_img between", value1, value2, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingImgNotBetween(String value1, String value2) {
            addCriterion("building_img not between", value1, value2, "buildingImg");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1IsNull() {
            addCriterion("building_pdf1 is null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1IsNotNull() {
            addCriterion("building_pdf1 is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1EqualTo(String value) {
            addCriterion("building_pdf1 =", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1NotEqualTo(String value) {
            addCriterion("building_pdf1 <>", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1GreaterThan(String value) {
            addCriterion("building_pdf1 >", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1GreaterThanOrEqualTo(String value) {
            addCriterion("building_pdf1 >=", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1LessThan(String value) {
            addCriterion("building_pdf1 <", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1LessThanOrEqualTo(String value) {
            addCriterion("building_pdf1 <=", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1Like(String value) {
            addCriterion("building_pdf1 like", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1NotLike(String value) {
            addCriterion("building_pdf1 not like", value, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1In(List<String> values) {
            addCriterion("building_pdf1 in", values, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1NotIn(List<String> values) {
            addCriterion("building_pdf1 not in", values, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1Between(String value1, String value2) {
            addCriterion("building_pdf1 between", value1, value2, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf1NotBetween(String value1, String value2) {
            addCriterion("building_pdf1 not between", value1, value2, "buildingPdf1");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2IsNull() {
            addCriterion("building_pdf2 is null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2IsNotNull() {
            addCriterion("building_pdf2 is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2EqualTo(String value) {
            addCriterion("building_pdf2 =", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2NotEqualTo(String value) {
            addCriterion("building_pdf2 <>", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2GreaterThan(String value) {
            addCriterion("building_pdf2 >", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2GreaterThanOrEqualTo(String value) {
            addCriterion("building_pdf2 >=", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2LessThan(String value) {
            addCriterion("building_pdf2 <", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2LessThanOrEqualTo(String value) {
            addCriterion("building_pdf2 <=", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2Like(String value) {
            addCriterion("building_pdf2 like", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2NotLike(String value) {
            addCriterion("building_pdf2 not like", value, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2In(List<String> values) {
            addCriterion("building_pdf2 in", values, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2NotIn(List<String> values) {
            addCriterion("building_pdf2 not in", values, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2Between(String value1, String value2) {
            addCriterion("building_pdf2 between", value1, value2, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf2NotBetween(String value1, String value2) {
            addCriterion("building_pdf2 not between", value1, value2, "buildingPdf2");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3IsNull() {
            addCriterion("building_pdf3 is null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3IsNotNull() {
            addCriterion("building_pdf3 is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3EqualTo(String value) {
            addCriterion("building_pdf3 =", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3NotEqualTo(String value) {
            addCriterion("building_pdf3 <>", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3GreaterThan(String value) {
            addCriterion("building_pdf3 >", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3GreaterThanOrEqualTo(String value) {
            addCriterion("building_pdf3 >=", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3LessThan(String value) {
            addCriterion("building_pdf3 <", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3LessThanOrEqualTo(String value) {
            addCriterion("building_pdf3 <=", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3Like(String value) {
            addCriterion("building_pdf3 like", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3NotLike(String value) {
            addCriterion("building_pdf3 not like", value, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3In(List<String> values) {
            addCriterion("building_pdf3 in", values, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3NotIn(List<String> values) {
            addCriterion("building_pdf3 not in", values, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3Between(String value1, String value2) {
            addCriterion("building_pdf3 between", value1, value2, "buildingPdf3");
            return (Criteria) this;
        }

        public Criteria andBuildingPdf3NotBetween(String value1, String value2) {
            addCriterion("building_pdf3 not between", value1, value2, "buildingPdf3");
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