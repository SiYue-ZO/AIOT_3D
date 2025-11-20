package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class HouseLayoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseLayoutExample() {
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

        public Criteria andLayoutIdIsNull() {
            addCriterion("layout_id is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIdIsNotNull() {
            addCriterion("layout_id is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutIdEqualTo(String value) {
            addCriterion("layout_id =", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotEqualTo(String value) {
            addCriterion("layout_id <>", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdGreaterThan(String value) {
            addCriterion("layout_id >", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdGreaterThanOrEqualTo(String value) {
            addCriterion("layout_id >=", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdLessThan(String value) {
            addCriterion("layout_id <", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdLessThanOrEqualTo(String value) {
            addCriterion("layout_id <=", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdLike(String value) {
            addCriterion("layout_id like", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotLike(String value) {
            addCriterion("layout_id not like", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdIn(List<String> values) {
            addCriterion("layout_id in", values, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotIn(List<String> values) {
            addCriterion("layout_id not in", values, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdBetween(String value1, String value2) {
            addCriterion("layout_id between", value1, value2, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotBetween(String value1, String value2) {
            addCriterion("layout_id not between", value1, value2, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutPosIsNull() {
            addCriterion("layout_pos is null");
            return (Criteria) this;
        }

        public Criteria andLayoutPosIsNotNull() {
            addCriterion("layout_pos is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutPosEqualTo(String value) {
            addCriterion("layout_pos =", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosNotEqualTo(String value) {
            addCriterion("layout_pos <>", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosGreaterThan(String value) {
            addCriterion("layout_pos >", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosGreaterThanOrEqualTo(String value) {
            addCriterion("layout_pos >=", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosLessThan(String value) {
            addCriterion("layout_pos <", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosLessThanOrEqualTo(String value) {
            addCriterion("layout_pos <=", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosLike(String value) {
            addCriterion("layout_pos like", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosNotLike(String value) {
            addCriterion("layout_pos not like", value, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosIn(List<String> values) {
            addCriterion("layout_pos in", values, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosNotIn(List<String> values) {
            addCriterion("layout_pos not in", values, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosBetween(String value1, String value2) {
            addCriterion("layout_pos between", value1, value2, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutPosNotBetween(String value1, String value2) {
            addCriterion("layout_pos not between", value1, value2, "layoutPos");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorIsNull() {
            addCriterion("layout_floor is null");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorIsNotNull() {
            addCriterion("layout_floor is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorEqualTo(String value) {
            addCriterion("layout_floor =", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorNotEqualTo(String value) {
            addCriterion("layout_floor <>", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorGreaterThan(String value) {
            addCriterion("layout_floor >", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorGreaterThanOrEqualTo(String value) {
            addCriterion("layout_floor >=", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorLessThan(String value) {
            addCriterion("layout_floor <", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorLessThanOrEqualTo(String value) {
            addCriterion("layout_floor <=", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorLike(String value) {
            addCriterion("layout_floor like", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorNotLike(String value) {
            addCriterion("layout_floor not like", value, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorIn(List<String> values) {
            addCriterion("layout_floor in", values, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorNotIn(List<String> values) {
            addCriterion("layout_floor not in", values, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorBetween(String value1, String value2) {
            addCriterion("layout_floor between", value1, value2, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutFloorNotBetween(String value1, String value2) {
            addCriterion("layout_floor not between", value1, value2, "layoutFloor");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIsNull() {
            addCriterion("layout_name is null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIsNotNull() {
            addCriterion("layout_name is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameEqualTo(String value) {
            addCriterion("layout_name =", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotEqualTo(String value) {
            addCriterion("layout_name <>", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThan(String value) {
            addCriterion("layout_name >", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("layout_name >=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThan(String value) {
            addCriterion("layout_name <", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThanOrEqualTo(String value) {
            addCriterion("layout_name <=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLike(String value) {
            addCriterion("layout_name like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotLike(String value) {
            addCriterion("layout_name not like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIn(List<String> values) {
            addCriterion("layout_name in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotIn(List<String> values) {
            addCriterion("layout_name not in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameBetween(String value1, String value2) {
            addCriterion("layout_name between", value1, value2, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotBetween(String value1, String value2) {
            addCriterion("layout_name not between", value1, value2, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightIsNull() {
            addCriterion("layout_height is null");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightIsNotNull() {
            addCriterion("layout_height is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightEqualTo(String value) {
            addCriterion("layout_height =", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightNotEqualTo(String value) {
            addCriterion("layout_height <>", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightGreaterThan(String value) {
            addCriterion("layout_height >", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightGreaterThanOrEqualTo(String value) {
            addCriterion("layout_height >=", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightLessThan(String value) {
            addCriterion("layout_height <", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightLessThanOrEqualTo(String value) {
            addCriterion("layout_height <=", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightLike(String value) {
            addCriterion("layout_height like", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightNotLike(String value) {
            addCriterion("layout_height not like", value, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightIn(List<String> values) {
            addCriterion("layout_height in", values, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightNotIn(List<String> values) {
            addCriterion("layout_height not in", values, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightBetween(String value1, String value2) {
            addCriterion("layout_height between", value1, value2, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andLayoutHeightNotBetween(String value1, String value2) {
            addCriterion("layout_height not between", value1, value2, "layoutHeight");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(String value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(String value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(String value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(String value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(String value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLike(String value) {
            addCriterion("add_id like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotLike(String value) {
            addCriterion("add_id not like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<String> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<String> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(String value1, String value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(String value1, String value2) {
            addCriterion("add_id not between", value1, value2, "addId");
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