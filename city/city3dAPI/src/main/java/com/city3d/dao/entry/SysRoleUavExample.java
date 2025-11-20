package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysRoleUavExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleUavExample() {
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

        public Criteria andRoleUavIdIsNull() {
            addCriterion("role_uav_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdIsNotNull() {
            addCriterion("role_uav_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdEqualTo(String value) {
            addCriterion("role_uav_id =", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdNotEqualTo(String value) {
            addCriterion("role_uav_id <>", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdGreaterThan(String value) {
            addCriterion("role_uav_id >", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_uav_id >=", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdLessThan(String value) {
            addCriterion("role_uav_id <", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdLessThanOrEqualTo(String value) {
            addCriterion("role_uav_id <=", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdLike(String value) {
            addCriterion("role_uav_id like", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdNotLike(String value) {
            addCriterion("role_uav_id not like", value, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdIn(List<String> values) {
            addCriterion("role_uav_id in", values, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdNotIn(List<String> values) {
            addCriterion("role_uav_id not in", values, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdBetween(String value1, String value2) {
            addCriterion("role_uav_id between", value1, value2, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleUavIdNotBetween(String value1, String value2) {
            addCriterion("role_uav_id not between", value1, value2, "roleUavId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andUavIdIsNull() {
            addCriterion("uav_id is null");
            return (Criteria) this;
        }

        public Criteria andUavIdIsNotNull() {
            addCriterion("uav_id is not null");
            return (Criteria) this;
        }

        public Criteria andUavIdEqualTo(String value) {
            addCriterion("uav_id =", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotEqualTo(String value) {
            addCriterion("uav_id <>", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdGreaterThan(String value) {
            addCriterion("uav_id >", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdGreaterThanOrEqualTo(String value) {
            addCriterion("uav_id >=", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLessThan(String value) {
            addCriterion("uav_id <", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLessThanOrEqualTo(String value) {
            addCriterion("uav_id <=", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdLike(String value) {
            addCriterion("uav_id like", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotLike(String value) {
            addCriterion("uav_id not like", value, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdIn(List<String> values) {
            addCriterion("uav_id in", values, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotIn(List<String> values) {
            addCriterion("uav_id not in", values, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdBetween(String value1, String value2) {
            addCriterion("uav_id between", value1, value2, "uavId");
            return (Criteria) this;
        }

        public Criteria andUavIdNotBetween(String value1, String value2) {
            addCriterion("uav_id not between", value1, value2, "uavId");
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