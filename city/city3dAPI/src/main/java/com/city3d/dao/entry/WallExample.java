package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class WallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WallExample() {
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

        public Criteria andWallIdIsNull() {
            addCriterion("wall_id is null");
            return (Criteria) this;
        }

        public Criteria andWallIdIsNotNull() {
            addCriterion("wall_id is not null");
            return (Criteria) this;
        }

        public Criteria andWallIdEqualTo(String value) {
            addCriterion("wall_id =", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotEqualTo(String value) {
            addCriterion("wall_id <>", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdGreaterThan(String value) {
            addCriterion("wall_id >", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdGreaterThanOrEqualTo(String value) {
            addCriterion("wall_id >=", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLessThan(String value) {
            addCriterion("wall_id <", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLessThanOrEqualTo(String value) {
            addCriterion("wall_id <=", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdLike(String value) {
            addCriterion("wall_id like", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotLike(String value) {
            addCriterion("wall_id not like", value, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdIn(List<String> values) {
            addCriterion("wall_id in", values, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotIn(List<String> values) {
            addCriterion("wall_id not in", values, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdBetween(String value1, String value2) {
            addCriterion("wall_id between", value1, value2, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallIdNotBetween(String value1, String value2) {
            addCriterion("wall_id not between", value1, value2, "wallId");
            return (Criteria) this;
        }

        public Criteria andWallPoiIsNull() {
            addCriterion("wall_poi is null");
            return (Criteria) this;
        }

        public Criteria andWallPoiIsNotNull() {
            addCriterion("wall_poi is not null");
            return (Criteria) this;
        }

        public Criteria andWallPoiEqualTo(String value) {
            addCriterion("wall_poi =", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiNotEqualTo(String value) {
            addCriterion("wall_poi <>", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiGreaterThan(String value) {
            addCriterion("wall_poi >", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiGreaterThanOrEqualTo(String value) {
            addCriterion("wall_poi >=", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiLessThan(String value) {
            addCriterion("wall_poi <", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiLessThanOrEqualTo(String value) {
            addCriterion("wall_poi <=", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiLike(String value) {
            addCriterion("wall_poi like", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiNotLike(String value) {
            addCriterion("wall_poi not like", value, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiIn(List<String> values) {
            addCriterion("wall_poi in", values, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiNotIn(List<String> values) {
            addCriterion("wall_poi not in", values, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiBetween(String value1, String value2) {
            addCriterion("wall_poi between", value1, value2, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallPoiNotBetween(String value1, String value2) {
            addCriterion("wall_poi not between", value1, value2, "wallPoi");
            return (Criteria) this;
        }

        public Criteria andWallInIsNull() {
            addCriterion("wall_in is null");
            return (Criteria) this;
        }

        public Criteria andWallInIsNotNull() {
            addCriterion("wall_in is not null");
            return (Criteria) this;
        }

        public Criteria andWallInEqualTo(String value) {
            addCriterion("wall_in =", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInNotEqualTo(String value) {
            addCriterion("wall_in <>", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInGreaterThan(String value) {
            addCriterion("wall_in >", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInGreaterThanOrEqualTo(String value) {
            addCriterion("wall_in >=", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInLessThan(String value) {
            addCriterion("wall_in <", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInLessThanOrEqualTo(String value) {
            addCriterion("wall_in <=", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInLike(String value) {
            addCriterion("wall_in like", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInNotLike(String value) {
            addCriterion("wall_in not like", value, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInIn(List<String> values) {
            addCriterion("wall_in in", values, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInNotIn(List<String> values) {
            addCriterion("wall_in not in", values, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInBetween(String value1, String value2) {
            addCriterion("wall_in between", value1, value2, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallInNotBetween(String value1, String value2) {
            addCriterion("wall_in not between", value1, value2, "wallIn");
            return (Criteria) this;
        }

        public Criteria andWallOutIsNull() {
            addCriterion("wall_out is null");
            return (Criteria) this;
        }

        public Criteria andWallOutIsNotNull() {
            addCriterion("wall_out is not null");
            return (Criteria) this;
        }

        public Criteria andWallOutEqualTo(String value) {
            addCriterion("wall_out =", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutNotEqualTo(String value) {
            addCriterion("wall_out <>", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutGreaterThan(String value) {
            addCriterion("wall_out >", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutGreaterThanOrEqualTo(String value) {
            addCriterion("wall_out >=", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutLessThan(String value) {
            addCriterion("wall_out <", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutLessThanOrEqualTo(String value) {
            addCriterion("wall_out <=", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutLike(String value) {
            addCriterion("wall_out like", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutNotLike(String value) {
            addCriterion("wall_out not like", value, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutIn(List<String> values) {
            addCriterion("wall_out in", values, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutNotIn(List<String> values) {
            addCriterion("wall_out not in", values, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutBetween(String value1, String value2) {
            addCriterion("wall_out between", value1, value2, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallOutNotBetween(String value1, String value2) {
            addCriterion("wall_out not between", value1, value2, "wallOut");
            return (Criteria) this;
        }

        public Criteria andWallNameIsNull() {
            addCriterion("wall_name is null");
            return (Criteria) this;
        }

        public Criteria andWallNameIsNotNull() {
            addCriterion("wall_name is not null");
            return (Criteria) this;
        }

        public Criteria andWallNameEqualTo(String value) {
            addCriterion("wall_name =", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameNotEqualTo(String value) {
            addCriterion("wall_name <>", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameGreaterThan(String value) {
            addCriterion("wall_name >", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameGreaterThanOrEqualTo(String value) {
            addCriterion("wall_name >=", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameLessThan(String value) {
            addCriterion("wall_name <", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameLessThanOrEqualTo(String value) {
            addCriterion("wall_name <=", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameLike(String value) {
            addCriterion("wall_name like", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameNotLike(String value) {
            addCriterion("wall_name not like", value, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameIn(List<String> values) {
            addCriterion("wall_name in", values, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameNotIn(List<String> values) {
            addCriterion("wall_name not in", values, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameBetween(String value1, String value2) {
            addCriterion("wall_name between", value1, value2, "wallName");
            return (Criteria) this;
        }

        public Criteria andWallNameNotBetween(String value1, String value2) {
            addCriterion("wall_name not between", value1, value2, "wallName");
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