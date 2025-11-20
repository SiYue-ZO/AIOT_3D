package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class CityThingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityThingExample() {
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

        public Criteria andThingIdIsNull() {
            addCriterion("thing_id is null");
            return (Criteria) this;
        }

        public Criteria andThingIdIsNotNull() {
            addCriterion("thing_id is not null");
            return (Criteria) this;
        }

        public Criteria andThingIdEqualTo(String value) {
            addCriterion("thing_id =", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotEqualTo(String value) {
            addCriterion("thing_id <>", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdGreaterThan(String value) {
            addCriterion("thing_id >", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdGreaterThanOrEqualTo(String value) {
            addCriterion("thing_id >=", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdLessThan(String value) {
            addCriterion("thing_id <", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdLessThanOrEqualTo(String value) {
            addCriterion("thing_id <=", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdLike(String value) {
            addCriterion("thing_id like", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotLike(String value) {
            addCriterion("thing_id not like", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdIn(List<String> values) {
            addCriterion("thing_id in", values, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotIn(List<String> values) {
            addCriterion("thing_id not in", values, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdBetween(String value1, String value2) {
            addCriterion("thing_id between", value1, value2, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotBetween(String value1, String value2) {
            addCriterion("thing_id not between", value1, value2, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingTypeIsNull() {
            addCriterion("thing_type is null");
            return (Criteria) this;
        }

        public Criteria andThingTypeIsNotNull() {
            addCriterion("thing_type is not null");
            return (Criteria) this;
        }

        public Criteria andThingTypeEqualTo(String value) {
            addCriterion("thing_type =", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeNotEqualTo(String value) {
            addCriterion("thing_type <>", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeGreaterThan(String value) {
            addCriterion("thing_type >", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("thing_type >=", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeLessThan(String value) {
            addCriterion("thing_type <", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeLessThanOrEqualTo(String value) {
            addCriterion("thing_type <=", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeLike(String value) {
            addCriterion("thing_type like", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeNotLike(String value) {
            addCriterion("thing_type not like", value, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeIn(List<String> values) {
            addCriterion("thing_type in", values, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeNotIn(List<String> values) {
            addCriterion("thing_type not in", values, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeBetween(String value1, String value2) {
            addCriterion("thing_type between", value1, value2, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingTypeNotBetween(String value1, String value2) {
            addCriterion("thing_type not between", value1, value2, "thingType");
            return (Criteria) this;
        }

        public Criteria andThingNameIsNull() {
            addCriterion("thing_name is null");
            return (Criteria) this;
        }

        public Criteria andThingNameIsNotNull() {
            addCriterion("thing_name is not null");
            return (Criteria) this;
        }

        public Criteria andThingNameEqualTo(String value) {
            addCriterion("thing_name =", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameNotEqualTo(String value) {
            addCriterion("thing_name <>", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameGreaterThan(String value) {
            addCriterion("thing_name >", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameGreaterThanOrEqualTo(String value) {
            addCriterion("thing_name >=", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameLessThan(String value) {
            addCriterion("thing_name <", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameLessThanOrEqualTo(String value) {
            addCriterion("thing_name <=", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameLike(String value) {
            addCriterion("thing_name like", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameNotLike(String value) {
            addCriterion("thing_name not like", value, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameIn(List<String> values) {
            addCriterion("thing_name in", values, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameNotIn(List<String> values) {
            addCriterion("thing_name not in", values, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameBetween(String value1, String value2) {
            addCriterion("thing_name between", value1, value2, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingNameNotBetween(String value1, String value2) {
            addCriterion("thing_name not between", value1, value2, "thingName");
            return (Criteria) this;
        }

        public Criteria andThingPosIsNull() {
            addCriterion("thing_pos is null");
            return (Criteria) this;
        }

        public Criteria andThingPosIsNotNull() {
            addCriterion("thing_pos is not null");
            return (Criteria) this;
        }

        public Criteria andThingPosEqualTo(String value) {
            addCriterion("thing_pos =", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosNotEqualTo(String value) {
            addCriterion("thing_pos <>", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosGreaterThan(String value) {
            addCriterion("thing_pos >", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosGreaterThanOrEqualTo(String value) {
            addCriterion("thing_pos >=", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosLessThan(String value) {
            addCriterion("thing_pos <", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosLessThanOrEqualTo(String value) {
            addCriterion("thing_pos <=", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosLike(String value) {
            addCriterion("thing_pos like", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosNotLike(String value) {
            addCriterion("thing_pos not like", value, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosIn(List<String> values) {
            addCriterion("thing_pos in", values, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosNotIn(List<String> values) {
            addCriterion("thing_pos not in", values, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosBetween(String value1, String value2) {
            addCriterion("thing_pos between", value1, value2, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingPosNotBetween(String value1, String value2) {
            addCriterion("thing_pos not between", value1, value2, "thingPos");
            return (Criteria) this;
        }

        public Criteria andThingNetIsNull() {
            addCriterion("thing_net is null");
            return (Criteria) this;
        }

        public Criteria andThingNetIsNotNull() {
            addCriterion("thing_net is not null");
            return (Criteria) this;
        }

        public Criteria andThingNetEqualTo(String value) {
            addCriterion("thing_net =", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetNotEqualTo(String value) {
            addCriterion("thing_net <>", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetGreaterThan(String value) {
            addCriterion("thing_net >", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetGreaterThanOrEqualTo(String value) {
            addCriterion("thing_net >=", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetLessThan(String value) {
            addCriterion("thing_net <", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetLessThanOrEqualTo(String value) {
            addCriterion("thing_net <=", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetLike(String value) {
            addCriterion("thing_net like", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetNotLike(String value) {
            addCriterion("thing_net not like", value, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetIn(List<String> values) {
            addCriterion("thing_net in", values, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetNotIn(List<String> values) {
            addCriterion("thing_net not in", values, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetBetween(String value1, String value2) {
            addCriterion("thing_net between", value1, value2, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingNetNotBetween(String value1, String value2) {
            addCriterion("thing_net not between", value1, value2, "thingNet");
            return (Criteria) this;
        }

        public Criteria andThingDepIsNull() {
            addCriterion("thing_dep is null");
            return (Criteria) this;
        }

        public Criteria andThingDepIsNotNull() {
            addCriterion("thing_dep is not null");
            return (Criteria) this;
        }

        public Criteria andThingDepEqualTo(String value) {
            addCriterion("thing_dep =", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepNotEqualTo(String value) {
            addCriterion("thing_dep <>", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepGreaterThan(String value) {
            addCriterion("thing_dep >", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepGreaterThanOrEqualTo(String value) {
            addCriterion("thing_dep >=", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepLessThan(String value) {
            addCriterion("thing_dep <", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepLessThanOrEqualTo(String value) {
            addCriterion("thing_dep <=", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepLike(String value) {
            addCriterion("thing_dep like", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepNotLike(String value) {
            addCriterion("thing_dep not like", value, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepIn(List<String> values) {
            addCriterion("thing_dep in", values, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepNotIn(List<String> values) {
            addCriterion("thing_dep not in", values, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepBetween(String value1, String value2) {
            addCriterion("thing_dep between", value1, value2, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingDepNotBetween(String value1, String value2) {
            addCriterion("thing_dep not between", value1, value2, "thingDep");
            return (Criteria) this;
        }

        public Criteria andThingClassIsNull() {
            addCriterion("thing_class is null");
            return (Criteria) this;
        }

        public Criteria andThingClassIsNotNull() {
            addCriterion("thing_class is not null");
            return (Criteria) this;
        }

        public Criteria andThingClassEqualTo(String value) {
            addCriterion("thing_class =", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassNotEqualTo(String value) {
            addCriterion("thing_class <>", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassGreaterThan(String value) {
            addCriterion("thing_class >", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassGreaterThanOrEqualTo(String value) {
            addCriterion("thing_class >=", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassLessThan(String value) {
            addCriterion("thing_class <", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassLessThanOrEqualTo(String value) {
            addCriterion("thing_class <=", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassLike(String value) {
            addCriterion("thing_class like", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassNotLike(String value) {
            addCriterion("thing_class not like", value, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassIn(List<String> values) {
            addCriterion("thing_class in", values, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassNotIn(List<String> values) {
            addCriterion("thing_class not in", values, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassBetween(String value1, String value2) {
            addCriterion("thing_class between", value1, value2, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingClassNotBetween(String value1, String value2) {
            addCriterion("thing_class not between", value1, value2, "thingClass");
            return (Criteria) this;
        }

        public Criteria andThingPidIsNull() {
            addCriterion("thing_pid is null");
            return (Criteria) this;
        }

        public Criteria andThingPidIsNotNull() {
            addCriterion("thing_pid is not null");
            return (Criteria) this;
        }

        public Criteria andThingPidEqualTo(String value) {
            addCriterion("thing_pid =", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidNotEqualTo(String value) {
            addCriterion("thing_pid <>", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidGreaterThan(String value) {
            addCriterion("thing_pid >", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidGreaterThanOrEqualTo(String value) {
            addCriterion("thing_pid >=", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidLessThan(String value) {
            addCriterion("thing_pid <", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidLessThanOrEqualTo(String value) {
            addCriterion("thing_pid <=", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidLike(String value) {
            addCriterion("thing_pid like", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidNotLike(String value) {
            addCriterion("thing_pid not like", value, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidIn(List<String> values) {
            addCriterion("thing_pid in", values, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidNotIn(List<String> values) {
            addCriterion("thing_pid not in", values, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidBetween(String value1, String value2) {
            addCriterion("thing_pid between", value1, value2, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingPidNotBetween(String value1, String value2) {
            addCriterion("thing_pid not between", value1, value2, "thingPid");
            return (Criteria) this;
        }

        public Criteria andThingHeadingIsNull() {
            addCriterion("thing_heading is null");
            return (Criteria) this;
        }

        public Criteria andThingHeadingIsNotNull() {
            addCriterion("thing_heading is not null");
            return (Criteria) this;
        }

        public Criteria andThingHeadingEqualTo(String value) {
            addCriterion("thing_heading =", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingNotEqualTo(String value) {
            addCriterion("thing_heading <>", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingGreaterThan(String value) {
            addCriterion("thing_heading >", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("thing_heading >=", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingLessThan(String value) {
            addCriterion("thing_heading <", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingLessThanOrEqualTo(String value) {
            addCriterion("thing_heading <=", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingLike(String value) {
            addCriterion("thing_heading like", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingNotLike(String value) {
            addCriterion("thing_heading not like", value, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingIn(List<String> values) {
            addCriterion("thing_heading in", values, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingNotIn(List<String> values) {
            addCriterion("thing_heading not in", values, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingBetween(String value1, String value2) {
            addCriterion("thing_heading between", value1, value2, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingHeadingNotBetween(String value1, String value2) {
            addCriterion("thing_heading not between", value1, value2, "thingHeading");
            return (Criteria) this;
        }

        public Criteria andThingScaleIsNull() {
            addCriterion("thing_scale is null");
            return (Criteria) this;
        }

        public Criteria andThingScaleIsNotNull() {
            addCriterion("thing_scale is not null");
            return (Criteria) this;
        }

        public Criteria andThingScaleEqualTo(String value) {
            addCriterion("thing_scale =", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleNotEqualTo(String value) {
            addCriterion("thing_scale <>", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleGreaterThan(String value) {
            addCriterion("thing_scale >", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleGreaterThanOrEqualTo(String value) {
            addCriterion("thing_scale >=", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleLessThan(String value) {
            addCriterion("thing_scale <", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleLessThanOrEqualTo(String value) {
            addCriterion("thing_scale <=", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleLike(String value) {
            addCriterion("thing_scale like", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleNotLike(String value) {
            addCriterion("thing_scale not like", value, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleIn(List<String> values) {
            addCriterion("thing_scale in", values, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleNotIn(List<String> values) {
            addCriterion("thing_scale not in", values, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleBetween(String value1, String value2) {
            addCriterion("thing_scale between", value1, value2, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingScaleNotBetween(String value1, String value2) {
            addCriterion("thing_scale not between", value1, value2, "thingScale");
            return (Criteria) this;
        }

        public Criteria andThingUrlIsNull() {
            addCriterion("thing_url is null");
            return (Criteria) this;
        }

        public Criteria andThingUrlIsNotNull() {
            addCriterion("thing_url is not null");
            return (Criteria) this;
        }

        public Criteria andThingUrlEqualTo(String value) {
            addCriterion("thing_url =", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlNotEqualTo(String value) {
            addCriterion("thing_url <>", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlGreaterThan(String value) {
            addCriterion("thing_url >", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thing_url >=", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlLessThan(String value) {
            addCriterion("thing_url <", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlLessThanOrEqualTo(String value) {
            addCriterion("thing_url <=", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlLike(String value) {
            addCriterion("thing_url like", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlNotLike(String value) {
            addCriterion("thing_url not like", value, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlIn(List<String> values) {
            addCriterion("thing_url in", values, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlNotIn(List<String> values) {
            addCriterion("thing_url not in", values, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlBetween(String value1, String value2) {
            addCriterion("thing_url between", value1, value2, "thingUrl");
            return (Criteria) this;
        }

        public Criteria andThingUrlNotBetween(String value1, String value2) {
            addCriterion("thing_url not between", value1, value2, "thingUrl");
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