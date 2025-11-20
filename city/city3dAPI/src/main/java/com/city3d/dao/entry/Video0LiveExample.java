package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class Video0LiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Video0LiveExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCamIpIsNull() {
            addCriterion("cam_ip is null");
            return (Criteria) this;
        }

        public Criteria andCamIpIsNotNull() {
            addCriterion("cam_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCamIpEqualTo(String value) {
            addCriterion("cam_ip =", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpNotEqualTo(String value) {
            addCriterion("cam_ip <>", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpGreaterThan(String value) {
            addCriterion("cam_ip >", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpGreaterThanOrEqualTo(String value) {
            addCriterion("cam_ip >=", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpLessThan(String value) {
            addCriterion("cam_ip <", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpLessThanOrEqualTo(String value) {
            addCriterion("cam_ip <=", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpLike(String value) {
            addCriterion("cam_ip like", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpNotLike(String value) {
            addCriterion("cam_ip not like", value, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpIn(List<String> values) {
            addCriterion("cam_ip in", values, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpNotIn(List<String> values) {
            addCriterion("cam_ip not in", values, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpBetween(String value1, String value2) {
            addCriterion("cam_ip between", value1, value2, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamIpNotBetween(String value1, String value2) {
            addCriterion("cam_ip not between", value1, value2, "camIp");
            return (Criteria) this;
        }

        public Criteria andCamUserIsNull() {
            addCriterion("cam_user is null");
            return (Criteria) this;
        }

        public Criteria andCamUserIsNotNull() {
            addCriterion("cam_user is not null");
            return (Criteria) this;
        }

        public Criteria andCamUserEqualTo(String value) {
            addCriterion("cam_user =", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserNotEqualTo(String value) {
            addCriterion("cam_user <>", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserGreaterThan(String value) {
            addCriterion("cam_user >", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserGreaterThanOrEqualTo(String value) {
            addCriterion("cam_user >=", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserLessThan(String value) {
            addCriterion("cam_user <", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserLessThanOrEqualTo(String value) {
            addCriterion("cam_user <=", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserLike(String value) {
            addCriterion("cam_user like", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserNotLike(String value) {
            addCriterion("cam_user not like", value, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserIn(List<String> values) {
            addCriterion("cam_user in", values, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserNotIn(List<String> values) {
            addCriterion("cam_user not in", values, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserBetween(String value1, String value2) {
            addCriterion("cam_user between", value1, value2, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamUserNotBetween(String value1, String value2) {
            addCriterion("cam_user not between", value1, value2, "camUser");
            return (Criteria) this;
        }

        public Criteria andCamPwIsNull() {
            addCriterion("cam_pw is null");
            return (Criteria) this;
        }

        public Criteria andCamPwIsNotNull() {
            addCriterion("cam_pw is not null");
            return (Criteria) this;
        }

        public Criteria andCamPwEqualTo(String value) {
            addCriterion("cam_pw =", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwNotEqualTo(String value) {
            addCriterion("cam_pw <>", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwGreaterThan(String value) {
            addCriterion("cam_pw >", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pw >=", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwLessThan(String value) {
            addCriterion("cam_pw <", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwLessThanOrEqualTo(String value) {
            addCriterion("cam_pw <=", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwLike(String value) {
            addCriterion("cam_pw like", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwNotLike(String value) {
            addCriterion("cam_pw not like", value, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwIn(List<String> values) {
            addCriterion("cam_pw in", values, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwNotIn(List<String> values) {
            addCriterion("cam_pw not in", values, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwBetween(String value1, String value2) {
            addCriterion("cam_pw between", value1, value2, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPwNotBetween(String value1, String value2) {
            addCriterion("cam_pw not between", value1, value2, "camPw");
            return (Criteria) this;
        }

        public Criteria andCamPortIsNull() {
            addCriterion("cam_port is null");
            return (Criteria) this;
        }

        public Criteria andCamPortIsNotNull() {
            addCriterion("cam_port is not null");
            return (Criteria) this;
        }

        public Criteria andCamPortEqualTo(String value) {
            addCriterion("cam_port =", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotEqualTo(String value) {
            addCriterion("cam_port <>", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortGreaterThan(String value) {
            addCriterion("cam_port >", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortGreaterThanOrEqualTo(String value) {
            addCriterion("cam_port >=", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLessThan(String value) {
            addCriterion("cam_port <", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLessThanOrEqualTo(String value) {
            addCriterion("cam_port <=", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLike(String value) {
            addCriterion("cam_port like", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotLike(String value) {
            addCriterion("cam_port not like", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortIn(List<String> values) {
            addCriterion("cam_port in", values, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotIn(List<String> values) {
            addCriterion("cam_port not in", values, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortBetween(String value1, String value2) {
            addCriterion("cam_port between", value1, value2, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotBetween(String value1, String value2) {
            addCriterion("cam_port not between", value1, value2, "camPort");
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