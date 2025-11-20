package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class EquipmentRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentRelExample() {
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

        public Criteria andEquipRelIdIsNull() {
            addCriterion("equip_rel_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdIsNotNull() {
            addCriterion("equip_rel_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdEqualTo(String value) {
            addCriterion("equip_rel_id =", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdNotEqualTo(String value) {
            addCriterion("equip_rel_id <>", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdGreaterThan(String value) {
            addCriterion("equip_rel_id >", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("equip_rel_id >=", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdLessThan(String value) {
            addCriterion("equip_rel_id <", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdLessThanOrEqualTo(String value) {
            addCriterion("equip_rel_id <=", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdLike(String value) {
            addCriterion("equip_rel_id like", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdNotLike(String value) {
            addCriterion("equip_rel_id not like", value, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdIn(List<String> values) {
            addCriterion("equip_rel_id in", values, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdNotIn(List<String> values) {
            addCriterion("equip_rel_id not in", values, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdBetween(String value1, String value2) {
            addCriterion("equip_rel_id between", value1, value2, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipRelIdNotBetween(String value1, String value2) {
            addCriterion("equip_rel_id not between", value1, value2, "equipRelId");
            return (Criteria) this;
        }

        public Criteria andEquipIdIsNull() {
            addCriterion("equip_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipIdIsNotNull() {
            addCriterion("equip_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipIdEqualTo(String value) {
            addCriterion("equip_id =", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotEqualTo(String value) {
            addCriterion("equip_id <>", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThan(String value) {
            addCriterion("equip_id >", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThanOrEqualTo(String value) {
            addCriterion("equip_id >=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThan(String value) {
            addCriterion("equip_id <", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThanOrEqualTo(String value) {
            addCriterion("equip_id <=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLike(String value) {
            addCriterion("equip_id like", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotLike(String value) {
            addCriterion("equip_id not like", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdIn(List<String> values) {
            addCriterion("equip_id in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotIn(List<String> values) {
            addCriterion("equip_id not in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdBetween(String value1, String value2) {
            addCriterion("equip_id between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotBetween(String value1, String value2) {
            addCriterion("equip_id not between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNull() {
            addCriterion("rel_id is null");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNotNull() {
            addCriterion("rel_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelIdEqualTo(String value) {
            addCriterion("rel_id =", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotEqualTo(String value) {
            addCriterion("rel_id <>", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThan(String value) {
            addCriterion("rel_id >", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("rel_id >=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThan(String value) {
            addCriterion("rel_id <", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThanOrEqualTo(String value) {
            addCriterion("rel_id <=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLike(String value) {
            addCriterion("rel_id like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotLike(String value) {
            addCriterion("rel_id not like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdIn(List<String> values) {
            addCriterion("rel_id in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotIn(List<String> values) {
            addCriterion("rel_id not in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdBetween(String value1, String value2) {
            addCriterion("rel_id between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotBetween(String value1, String value2) {
            addCriterion("rel_id not between", value1, value2, "relId");
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