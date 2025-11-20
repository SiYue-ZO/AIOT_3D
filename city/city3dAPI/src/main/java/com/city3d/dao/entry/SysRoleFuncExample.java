package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysRoleFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleFuncExample() {
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

        public Criteria andRoleFuncIdIsNull() {
            addCriterion("role_func_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdIsNotNull() {
            addCriterion("role_func_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdEqualTo(String value) {
            addCriterion("role_func_id =", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdNotEqualTo(String value) {
            addCriterion("role_func_id <>", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdGreaterThan(String value) {
            addCriterion("role_func_id >", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_func_id >=", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdLessThan(String value) {
            addCriterion("role_func_id <", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdLessThanOrEqualTo(String value) {
            addCriterion("role_func_id <=", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdLike(String value) {
            addCriterion("role_func_id like", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdNotLike(String value) {
            addCriterion("role_func_id not like", value, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdIn(List<String> values) {
            addCriterion("role_func_id in", values, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdNotIn(List<String> values) {
            addCriterion("role_func_id not in", values, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdBetween(String value1, String value2) {
            addCriterion("role_func_id between", value1, value2, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andRoleFuncIdNotBetween(String value1, String value2) {
            addCriterion("role_func_id not between", value1, value2, "roleFuncId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNull() {
            addCriterion("func_id is null");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNotNull() {
            addCriterion("func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIdEqualTo(String value) {
            addCriterion("func_id =", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotEqualTo(String value) {
            addCriterion("func_id <>", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThan(String value) {
            addCriterion("func_id >", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("func_id >=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThan(String value) {
            addCriterion("func_id <", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThanOrEqualTo(String value) {
            addCriterion("func_id <=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLike(String value) {
            addCriterion("func_id like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotLike(String value) {
            addCriterion("func_id not like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIn(List<String> values) {
            addCriterion("func_id in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotIn(List<String> values) {
            addCriterion("func_id not in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdBetween(String value1, String value2) {
            addCriterion("func_id between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotBetween(String value1, String value2) {
            addCriterion("func_id not between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
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

        public Criteria andRoleFuncPidIsNull() {
            addCriterion("role_func_pid is null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidIsNotNull() {
            addCriterion("role_func_pid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidEqualTo(String value) {
            addCriterion("role_func_pid =", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidNotEqualTo(String value) {
            addCriterion("role_func_pid <>", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidGreaterThan(String value) {
            addCriterion("role_func_pid >", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidGreaterThanOrEqualTo(String value) {
            addCriterion("role_func_pid >=", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidLessThan(String value) {
            addCriterion("role_func_pid <", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidLessThanOrEqualTo(String value) {
            addCriterion("role_func_pid <=", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidLike(String value) {
            addCriterion("role_func_pid like", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidNotLike(String value) {
            addCriterion("role_func_pid not like", value, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidIn(List<String> values) {
            addCriterion("role_func_pid in", values, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidNotIn(List<String> values) {
            addCriterion("role_func_pid not in", values, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidBetween(String value1, String value2) {
            addCriterion("role_func_pid between", value1, value2, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncPidNotBetween(String value1, String value2) {
            addCriterion("role_func_pid not between", value1, value2, "roleFuncPid");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderIsNull() {
            addCriterion("role_func_order is null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderIsNotNull() {
            addCriterion("role_func_order is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderEqualTo(Integer value) {
            addCriterion("role_func_order =", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderNotEqualTo(Integer value) {
            addCriterion("role_func_order <>", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderGreaterThan(Integer value) {
            addCriterion("role_func_order >", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_func_order >=", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderLessThan(Integer value) {
            addCriterion("role_func_order <", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderLessThanOrEqualTo(Integer value) {
            addCriterion("role_func_order <=", value, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderIn(List<Integer> values) {
            addCriterion("role_func_order in", values, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderNotIn(List<Integer> values) {
            addCriterion("role_func_order not in", values, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderBetween(Integer value1, Integer value2) {
            addCriterion("role_func_order between", value1, value2, "roleFuncOrder");
            return (Criteria) this;
        }

        public Criteria andRoleFuncOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("role_func_order not between", value1, value2, "roleFuncOrder");
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