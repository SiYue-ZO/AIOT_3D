package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysUserTiles3dExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserTiles3dExample() {
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

        public Criteria andUserTilesIdIsNull() {
            addCriterion("user_tiles_id is null");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdIsNotNull() {
            addCriterion("user_tiles_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdEqualTo(String value) {
            addCriterion("user_tiles_id =", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdNotEqualTo(String value) {
            addCriterion("user_tiles_id <>", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdGreaterThan(String value) {
            addCriterion("user_tiles_id >", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_tiles_id >=", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdLessThan(String value) {
            addCriterion("user_tiles_id <", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdLessThanOrEqualTo(String value) {
            addCriterion("user_tiles_id <=", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdLike(String value) {
            addCriterion("user_tiles_id like", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdNotLike(String value) {
            addCriterion("user_tiles_id not like", value, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdIn(List<String> values) {
            addCriterion("user_tiles_id in", values, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdNotIn(List<String> values) {
            addCriterion("user_tiles_id not in", values, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdBetween(String value1, String value2) {
            addCriterion("user_tiles_id between", value1, value2, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserTilesIdNotBetween(String value1, String value2) {
            addCriterion("user_tiles_id not between", value1, value2, "userTilesId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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