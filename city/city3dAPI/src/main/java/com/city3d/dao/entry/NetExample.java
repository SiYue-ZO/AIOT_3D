package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class NetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NetExample() {
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

        public Criteria andNetPidIsNull() {
            addCriterion("net_pid is null");
            return (Criteria) this;
        }

        public Criteria andNetPidIsNotNull() {
            addCriterion("net_pid is not null");
            return (Criteria) this;
        }

        public Criteria andNetPidEqualTo(String value) {
            addCriterion("net_pid =", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidNotEqualTo(String value) {
            addCriterion("net_pid <>", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidGreaterThan(String value) {
            addCriterion("net_pid >", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidGreaterThanOrEqualTo(String value) {
            addCriterion("net_pid >=", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidLessThan(String value) {
            addCriterion("net_pid <", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidLessThanOrEqualTo(String value) {
            addCriterion("net_pid <=", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidLike(String value) {
            addCriterion("net_pid like", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidNotLike(String value) {
            addCriterion("net_pid not like", value, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidIn(List<String> values) {
            addCriterion("net_pid in", values, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidNotIn(List<String> values) {
            addCriterion("net_pid not in", values, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidBetween(String value1, String value2) {
            addCriterion("net_pid between", value1, value2, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPidNotBetween(String value1, String value2) {
            addCriterion("net_pid not between", value1, value2, "netPid");
            return (Criteria) this;
        }

        public Criteria andNetPoiIsNull() {
            addCriterion("net_poi is null");
            return (Criteria) this;
        }

        public Criteria andNetPoiIsNotNull() {
            addCriterion("net_poi is not null");
            return (Criteria) this;
        }

        public Criteria andNetPoiEqualTo(String value) {
            addCriterion("net_poi =", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiNotEqualTo(String value) {
            addCriterion("net_poi <>", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiGreaterThan(String value) {
            addCriterion("net_poi >", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiGreaterThanOrEqualTo(String value) {
            addCriterion("net_poi >=", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiLessThan(String value) {
            addCriterion("net_poi <", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiLessThanOrEqualTo(String value) {
            addCriterion("net_poi <=", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiLike(String value) {
            addCriterion("net_poi like", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiNotLike(String value) {
            addCriterion("net_poi not like", value, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiIn(List<String> values) {
            addCriterion("net_poi in", values, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiNotIn(List<String> values) {
            addCriterion("net_poi not in", values, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiBetween(String value1, String value2) {
            addCriterion("net_poi between", value1, value2, "netPoi");
            return (Criteria) this;
        }

        public Criteria andNetPoiNotBetween(String value1, String value2) {
            addCriterion("net_poi not between", value1, value2, "netPoi");
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

        public Criteria andNetMasterIsNull() {
            addCriterion("net_master is null");
            return (Criteria) this;
        }

        public Criteria andNetMasterIsNotNull() {
            addCriterion("net_master is not null");
            return (Criteria) this;
        }

        public Criteria andNetMasterEqualTo(String value) {
            addCriterion("net_master =", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotEqualTo(String value) {
            addCriterion("net_master <>", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterGreaterThan(String value) {
            addCriterion("net_master >", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterGreaterThanOrEqualTo(String value) {
            addCriterion("net_master >=", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLessThan(String value) {
            addCriterion("net_master <", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLessThanOrEqualTo(String value) {
            addCriterion("net_master <=", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLike(String value) {
            addCriterion("net_master like", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotLike(String value) {
            addCriterion("net_master not like", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterIn(List<String> values) {
            addCriterion("net_master in", values, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotIn(List<String> values) {
            addCriterion("net_master not in", values, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterBetween(String value1, String value2) {
            addCriterion("net_master between", value1, value2, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotBetween(String value1, String value2) {
            addCriterion("net_master not between", value1, value2, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetListenerIsNull() {
            addCriterion("net_listener is null");
            return (Criteria) this;
        }

        public Criteria andNetListenerIsNotNull() {
            addCriterion("net_listener is not null");
            return (Criteria) this;
        }

        public Criteria andNetListenerEqualTo(String value) {
            addCriterion("net_listener =", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotEqualTo(String value) {
            addCriterion("net_listener <>", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerGreaterThan(String value) {
            addCriterion("net_listener >", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerGreaterThanOrEqualTo(String value) {
            addCriterion("net_listener >=", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLessThan(String value) {
            addCriterion("net_listener <", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLessThanOrEqualTo(String value) {
            addCriterion("net_listener <=", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLike(String value) {
            addCriterion("net_listener like", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotLike(String value) {
            addCriterion("net_listener not like", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerIn(List<String> values) {
            addCriterion("net_listener in", values, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotIn(List<String> values) {
            addCriterion("net_listener not in", values, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerBetween(String value1, String value2) {
            addCriterion("net_listener between", value1, value2, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotBetween(String value1, String value2) {
            addCriterion("net_listener not between", value1, value2, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIsNull() {
            addCriterion("net_base_people is null");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIsNotNull() {
            addCriterion("net_base_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleEqualTo(String value) {
            addCriterion("net_base_people =", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotEqualTo(String value) {
            addCriterion("net_base_people <>", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleGreaterThan(String value) {
            addCriterion("net_base_people >", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_base_people >=", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLessThan(String value) {
            addCriterion("net_base_people <", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLessThanOrEqualTo(String value) {
            addCriterion("net_base_people <=", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLike(String value) {
            addCriterion("net_base_people like", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotLike(String value) {
            addCriterion("net_base_people not like", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIn(List<String> values) {
            addCriterion("net_base_people in", values, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotIn(List<String> values) {
            addCriterion("net_base_people not in", values, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleBetween(String value1, String value2) {
            addCriterion("net_base_people between", value1, value2, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotBetween(String value1, String value2) {
            addCriterion("net_base_people not between", value1, value2, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIsNull() {
            addCriterion("net_hold_people is null");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIsNotNull() {
            addCriterion("net_hold_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleEqualTo(String value) {
            addCriterion("net_hold_people =", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotEqualTo(String value) {
            addCriterion("net_hold_people <>", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleGreaterThan(String value) {
            addCriterion("net_hold_people >", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_hold_people >=", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLessThan(String value) {
            addCriterion("net_hold_people <", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_hold_people <=", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLike(String value) {
            addCriterion("net_hold_people like", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotLike(String value) {
            addCriterion("net_hold_people not like", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIn(List<String> values) {
            addCriterion("net_hold_people in", values, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotIn(List<String> values) {
            addCriterion("net_hold_people not in", values, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleBetween(String value1, String value2) {
            addCriterion("net_hold_people between", value1, value2, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotBetween(String value1, String value2) {
            addCriterion("net_hold_people not between", value1, value2, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIsNull() {
            addCriterion("net_flow_people is null");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIsNotNull() {
            addCriterion("net_flow_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleEqualTo(String value) {
            addCriterion("net_flow_people =", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotEqualTo(String value) {
            addCriterion("net_flow_people <>", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleGreaterThan(String value) {
            addCriterion("net_flow_people >", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_flow_people >=", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLessThan(String value) {
            addCriterion("net_flow_people <", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_flow_people <=", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLike(String value) {
            addCriterion("net_flow_people like", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotLike(String value) {
            addCriterion("net_flow_people not like", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIn(List<String> values) {
            addCriterion("net_flow_people in", values, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotIn(List<String> values) {
            addCriterion("net_flow_people not in", values, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleBetween(String value1, String value2) {
            addCriterion("net_flow_people between", value1, value2, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotBetween(String value1, String value2) {
            addCriterion("net_flow_people not between", value1, value2, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetGroupIsNull() {
            addCriterion("net_group is null");
            return (Criteria) this;
        }

        public Criteria andNetGroupIsNotNull() {
            addCriterion("net_group is not null");
            return (Criteria) this;
        }

        public Criteria andNetGroupEqualTo(String value) {
            addCriterion("net_group =", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotEqualTo(String value) {
            addCriterion("net_group <>", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupGreaterThan(String value) {
            addCriterion("net_group >", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupGreaterThanOrEqualTo(String value) {
            addCriterion("net_group >=", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLessThan(String value) {
            addCriterion("net_group <", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLessThanOrEqualTo(String value) {
            addCriterion("net_group <=", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLike(String value) {
            addCriterion("net_group like", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotLike(String value) {
            addCriterion("net_group not like", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupIn(List<String> values) {
            addCriterion("net_group in", values, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotIn(List<String> values) {
            addCriterion("net_group not in", values, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupBetween(String value1, String value2) {
            addCriterion("net_group between", value1, value2, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotBetween(String value1, String value2) {
            addCriterion("net_group not between", value1, value2, "netGroup");
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

        public Criteria andNetComIsNull() {
            addCriterion("net_com is null");
            return (Criteria) this;
        }

        public Criteria andNetComIsNotNull() {
            addCriterion("net_com is not null");
            return (Criteria) this;
        }

        public Criteria andNetComEqualTo(String value) {
            addCriterion("net_com =", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComNotEqualTo(String value) {
            addCriterion("net_com <>", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComGreaterThan(String value) {
            addCriterion("net_com >", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComGreaterThanOrEqualTo(String value) {
            addCriterion("net_com >=", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComLessThan(String value) {
            addCriterion("net_com <", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComLessThanOrEqualTo(String value) {
            addCriterion("net_com <=", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComLike(String value) {
            addCriterion("net_com like", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComNotLike(String value) {
            addCriterion("net_com not like", value, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComIn(List<String> values) {
            addCriterion("net_com in", values, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComNotIn(List<String> values) {
            addCriterion("net_com not in", values, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComBetween(String value1, String value2) {
            addCriterion("net_com between", value1, value2, "netCom");
            return (Criteria) this;
        }

        public Criteria andNetComNotBetween(String value1, String value2) {
            addCriterion("net_com not between", value1, value2, "netCom");
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