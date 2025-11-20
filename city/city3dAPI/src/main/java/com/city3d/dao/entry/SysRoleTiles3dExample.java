package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysRoleTiles3dExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleTiles3dExample() {
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

        public Criteria andRoleTilesIdIsNull() {
            addCriterion("role_tiles_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdIsNotNull() {
            addCriterion("role_tiles_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdEqualTo(String value) {
            addCriterion("role_tiles_id =", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdNotEqualTo(String value) {
            addCriterion("role_tiles_id <>", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdGreaterThan(String value) {
            addCriterion("role_tiles_id >", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_tiles_id >=", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdLessThan(String value) {
            addCriterion("role_tiles_id <", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdLessThanOrEqualTo(String value) {
            addCriterion("role_tiles_id <=", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdLike(String value) {
            addCriterion("role_tiles_id like", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdNotLike(String value) {
            addCriterion("role_tiles_id not like", value, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdIn(List<String> values) {
            addCriterion("role_tiles_id in", values, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdNotIn(List<String> values) {
            addCriterion("role_tiles_id not in", values, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdBetween(String value1, String value2) {
            addCriterion("role_tiles_id between", value1, value2, "roleTilesId");
            return (Criteria) this;
        }

        public Criteria andRoleTilesIdNotBetween(String value1, String value2) {
            addCriterion("role_tiles_id not between", value1, value2, "roleTilesId");
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

        public Criteria andTilesIdIsNull() {
            addCriterion("tiles_id is null");
            return (Criteria) this;
        }

        public Criteria andTilesIdIsNotNull() {
            addCriterion("tiles_id is not null");
            return (Criteria) this;
        }

        public Criteria andTilesIdEqualTo(String value) {
            addCriterion("tiles_id =", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotEqualTo(String value) {
            addCriterion("tiles_id <>", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdGreaterThan(String value) {
            addCriterion("tiles_id >", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_id >=", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLessThan(String value) {
            addCriterion("tiles_id <", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLessThanOrEqualTo(String value) {
            addCriterion("tiles_id <=", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLike(String value) {
            addCriterion("tiles_id like", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotLike(String value) {
            addCriterion("tiles_id not like", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdIn(List<String> values) {
            addCriterion("tiles_id in", values, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotIn(List<String> values) {
            addCriterion("tiles_id not in", values, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdBetween(String value1, String value2) {
            addCriterion("tiles_id between", value1, value2, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotBetween(String value1, String value2) {
            addCriterion("tiles_id not between", value1, value2, "tilesId");
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