package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class BimWaterFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BimWaterFlowExample() {
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

        public Criteria andBimFlowIdIsNull() {
            addCriterion("bim_flow_id is null");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdIsNotNull() {
            addCriterion("bim_flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdEqualTo(String value) {
            addCriterion("bim_flow_id =", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdNotEqualTo(String value) {
            addCriterion("bim_flow_id <>", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdGreaterThan(String value) {
            addCriterion("bim_flow_id >", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdGreaterThanOrEqualTo(String value) {
            addCriterion("bim_flow_id >=", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdLessThan(String value) {
            addCriterion("bim_flow_id <", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdLessThanOrEqualTo(String value) {
            addCriterion("bim_flow_id <=", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdLike(String value) {
            addCriterion("bim_flow_id like", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdNotLike(String value) {
            addCriterion("bim_flow_id not like", value, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdIn(List<String> values) {
            addCriterion("bim_flow_id in", values, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdNotIn(List<String> values) {
            addCriterion("bim_flow_id not in", values, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdBetween(String value1, String value2) {
            addCriterion("bim_flow_id between", value1, value2, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andBimFlowIdNotBetween(String value1, String value2) {
            addCriterion("bim_flow_id not between", value1, value2, "bimFlowId");
            return (Criteria) this;
        }

        public Criteria andFlowPosIsNull() {
            addCriterion("flow_pos is null");
            return (Criteria) this;
        }

        public Criteria andFlowPosIsNotNull() {
            addCriterion("flow_pos is not null");
            return (Criteria) this;
        }

        public Criteria andFlowPosEqualTo(String value) {
            addCriterion("flow_pos =", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosNotEqualTo(String value) {
            addCriterion("flow_pos <>", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosGreaterThan(String value) {
            addCriterion("flow_pos >", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosGreaterThanOrEqualTo(String value) {
            addCriterion("flow_pos >=", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosLessThan(String value) {
            addCriterion("flow_pos <", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosLessThanOrEqualTo(String value) {
            addCriterion("flow_pos <=", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosLike(String value) {
            addCriterion("flow_pos like", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosNotLike(String value) {
            addCriterion("flow_pos not like", value, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosIn(List<String> values) {
            addCriterion("flow_pos in", values, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosNotIn(List<String> values) {
            addCriterion("flow_pos not in", values, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosBetween(String value1, String value2) {
            addCriterion("flow_pos between", value1, value2, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowPosNotBetween(String value1, String value2) {
            addCriterion("flow_pos not between", value1, value2, "flowPos");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNull() {
            addCriterion("flow_name is null");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNotNull() {
            addCriterion("flow_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNameEqualTo(String value) {
            addCriterion("flow_name =", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotEqualTo(String value) {
            addCriterion("flow_name <>", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThan(String value) {
            addCriterion("flow_name >", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThanOrEqualTo(String value) {
            addCriterion("flow_name >=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThan(String value) {
            addCriterion("flow_name <", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThanOrEqualTo(String value) {
            addCriterion("flow_name <=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLike(String value) {
            addCriterion("flow_name like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotLike(String value) {
            addCriterion("flow_name not like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameIn(List<String> values) {
            addCriterion("flow_name in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotIn(List<String> values) {
            addCriterion("flow_name not in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameBetween(String value1, String value2) {
            addCriterion("flow_name between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotBetween(String value1, String value2) {
            addCriterion("flow_name not between", value1, value2, "flowName");
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