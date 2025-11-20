package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class RoamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoamExample() {
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

        public Criteria andRoamIdIsNull() {
            addCriterion("roam_id is null");
            return (Criteria) this;
        }

        public Criteria andRoamIdIsNotNull() {
            addCriterion("roam_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoamIdEqualTo(String value) {
            addCriterion("roam_id =", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdNotEqualTo(String value) {
            addCriterion("roam_id <>", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdGreaterThan(String value) {
            addCriterion("roam_id >", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdGreaterThanOrEqualTo(String value) {
            addCriterion("roam_id >=", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdLessThan(String value) {
            addCriterion("roam_id <", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdLessThanOrEqualTo(String value) {
            addCriterion("roam_id <=", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdLike(String value) {
            addCriterion("roam_id like", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdNotLike(String value) {
            addCriterion("roam_id not like", value, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdIn(List<String> values) {
            addCriterion("roam_id in", values, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdNotIn(List<String> values) {
            addCriterion("roam_id not in", values, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdBetween(String value1, String value2) {
            addCriterion("roam_id between", value1, value2, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamIdNotBetween(String value1, String value2) {
            addCriterion("roam_id not between", value1, value2, "roamId");
            return (Criteria) this;
        }

        public Criteria andRoamNameIsNull() {
            addCriterion("roam_name is null");
            return (Criteria) this;
        }

        public Criteria andRoamNameIsNotNull() {
            addCriterion("roam_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoamNameEqualTo(String value) {
            addCriterion("roam_name =", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameNotEqualTo(String value) {
            addCriterion("roam_name <>", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameGreaterThan(String value) {
            addCriterion("roam_name >", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameGreaterThanOrEqualTo(String value) {
            addCriterion("roam_name >=", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameLessThan(String value) {
            addCriterion("roam_name <", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameLessThanOrEqualTo(String value) {
            addCriterion("roam_name <=", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameLike(String value) {
            addCriterion("roam_name like", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameNotLike(String value) {
            addCriterion("roam_name not like", value, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameIn(List<String> values) {
            addCriterion("roam_name in", values, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameNotIn(List<String> values) {
            addCriterion("roam_name not in", values, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameBetween(String value1, String value2) {
            addCriterion("roam_name between", value1, value2, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamNameNotBetween(String value1, String value2) {
            addCriterion("roam_name not between", value1, value2, "roamName");
            return (Criteria) this;
        }

        public Criteria andRoamModelIsNull() {
            addCriterion("roam_model is null");
            return (Criteria) this;
        }

        public Criteria andRoamModelIsNotNull() {
            addCriterion("roam_model is not null");
            return (Criteria) this;
        }

        public Criteria andRoamModelEqualTo(String value) {
            addCriterion("roam_model =", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelNotEqualTo(String value) {
            addCriterion("roam_model <>", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelGreaterThan(String value) {
            addCriterion("roam_model >", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelGreaterThanOrEqualTo(String value) {
            addCriterion("roam_model >=", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelLessThan(String value) {
            addCriterion("roam_model <", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelLessThanOrEqualTo(String value) {
            addCriterion("roam_model <=", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelLike(String value) {
            addCriterion("roam_model like", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelNotLike(String value) {
            addCriterion("roam_model not like", value, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelIn(List<String> values) {
            addCriterion("roam_model in", values, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelNotIn(List<String> values) {
            addCriterion("roam_model not in", values, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelBetween(String value1, String value2) {
            addCriterion("roam_model between", value1, value2, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamModelNotBetween(String value1, String value2) {
            addCriterion("roam_model not between", value1, value2, "roamModel");
            return (Criteria) this;
        }

        public Criteria andRoamLineIsNull() {
            addCriterion("roam_line is null");
            return (Criteria) this;
        }

        public Criteria andRoamLineIsNotNull() {
            addCriterion("roam_line is not null");
            return (Criteria) this;
        }

        public Criteria andRoamLineEqualTo(String value) {
            addCriterion("roam_line =", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineNotEqualTo(String value) {
            addCriterion("roam_line <>", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineGreaterThan(String value) {
            addCriterion("roam_line >", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineGreaterThanOrEqualTo(String value) {
            addCriterion("roam_line >=", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineLessThan(String value) {
            addCriterion("roam_line <", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineLessThanOrEqualTo(String value) {
            addCriterion("roam_line <=", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineLike(String value) {
            addCriterion("roam_line like", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineNotLike(String value) {
            addCriterion("roam_line not like", value, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineIn(List<String> values) {
            addCriterion("roam_line in", values, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineNotIn(List<String> values) {
            addCriterion("roam_line not in", values, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineBetween(String value1, String value2) {
            addCriterion("roam_line between", value1, value2, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamLineNotBetween(String value1, String value2) {
            addCriterion("roam_line not between", value1, value2, "roamLine");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowIsNull() {
            addCriterion("roam_isshow is null");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowIsNotNull() {
            addCriterion("roam_isshow is not null");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowEqualTo(String value) {
            addCriterion("roam_isshow =", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowNotEqualTo(String value) {
            addCriterion("roam_isshow <>", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowGreaterThan(String value) {
            addCriterion("roam_isshow >", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowGreaterThanOrEqualTo(String value) {
            addCriterion("roam_isshow >=", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowLessThan(String value) {
            addCriterion("roam_isshow <", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowLessThanOrEqualTo(String value) {
            addCriterion("roam_isshow <=", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowLike(String value) {
            addCriterion("roam_isshow like", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowNotLike(String value) {
            addCriterion("roam_isshow not like", value, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowIn(List<String> values) {
            addCriterion("roam_isshow in", values, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowNotIn(List<String> values) {
            addCriterion("roam_isshow not in", values, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowBetween(String value1, String value2) {
            addCriterion("roam_isshow between", value1, value2, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsshowNotBetween(String value1, String value2) {
            addCriterion("roam_isshow not between", value1, value2, "roamIsshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsreIsNull() {
            addCriterion("roam_isre is null");
            return (Criteria) this;
        }

        public Criteria andRoamIsreIsNotNull() {
            addCriterion("roam_isre is not null");
            return (Criteria) this;
        }

        public Criteria andRoamIsreEqualTo(String value) {
            addCriterion("roam_isre =", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreNotEqualTo(String value) {
            addCriterion("roam_isre <>", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreGreaterThan(String value) {
            addCriterion("roam_isre >", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreGreaterThanOrEqualTo(String value) {
            addCriterion("roam_isre >=", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreLessThan(String value) {
            addCriterion("roam_isre <", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreLessThanOrEqualTo(String value) {
            addCriterion("roam_isre <=", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreLike(String value) {
            addCriterion("roam_isre like", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreNotLike(String value) {
            addCriterion("roam_isre not like", value, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreIn(List<String> values) {
            addCriterion("roam_isre in", values, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreNotIn(List<String> values) {
            addCriterion("roam_isre not in", values, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreBetween(String value1, String value2) {
            addCriterion("roam_isre between", value1, value2, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamIsreNotBetween(String value1, String value2) {
            addCriterion("roam_isre not between", value1, value2, "roamIsre");
            return (Criteria) this;
        }

        public Criteria andRoamNoteIsNull() {
            addCriterion("roam_note is null");
            return (Criteria) this;
        }

        public Criteria andRoamNoteIsNotNull() {
            addCriterion("roam_note is not null");
            return (Criteria) this;
        }

        public Criteria andRoamNoteEqualTo(String value) {
            addCriterion("roam_note =", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteNotEqualTo(String value) {
            addCriterion("roam_note <>", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteGreaterThan(String value) {
            addCriterion("roam_note >", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteGreaterThanOrEqualTo(String value) {
            addCriterion("roam_note >=", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteLessThan(String value) {
            addCriterion("roam_note <", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteLessThanOrEqualTo(String value) {
            addCriterion("roam_note <=", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteLike(String value) {
            addCriterion("roam_note like", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteNotLike(String value) {
            addCriterion("roam_note not like", value, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteIn(List<String> values) {
            addCriterion("roam_note in", values, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteNotIn(List<String> values) {
            addCriterion("roam_note not in", values, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteBetween(String value1, String value2) {
            addCriterion("roam_note between", value1, value2, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamNoteNotBetween(String value1, String value2) {
            addCriterion("roam_note not between", value1, value2, "roamNote");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedIsNull() {
            addCriterion("roam_speed is null");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedIsNotNull() {
            addCriterion("roam_speed is not null");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedEqualTo(String value) {
            addCriterion("roam_speed =", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedNotEqualTo(String value) {
            addCriterion("roam_speed <>", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedGreaterThan(String value) {
            addCriterion("roam_speed >", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("roam_speed >=", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedLessThan(String value) {
            addCriterion("roam_speed <", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedLessThanOrEqualTo(String value) {
            addCriterion("roam_speed <=", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedLike(String value) {
            addCriterion("roam_speed like", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedNotLike(String value) {
            addCriterion("roam_speed not like", value, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedIn(List<String> values) {
            addCriterion("roam_speed in", values, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedNotIn(List<String> values) {
            addCriterion("roam_speed not in", values, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedBetween(String value1, String value2) {
            addCriterion("roam_speed between", value1, value2, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamSpeedNotBetween(String value1, String value2) {
            addCriterion("roam_speed not between", value1, value2, "roamSpeed");
            return (Criteria) this;
        }

        public Criteria andRoamTypeIsNull() {
            addCriterion("roam_type is null");
            return (Criteria) this;
        }

        public Criteria andRoamTypeIsNotNull() {
            addCriterion("roam_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoamTypeEqualTo(String value) {
            addCriterion("roam_type =", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeNotEqualTo(String value) {
            addCriterion("roam_type <>", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeGreaterThan(String value) {
            addCriterion("roam_type >", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("roam_type >=", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeLessThan(String value) {
            addCriterion("roam_type <", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeLessThanOrEqualTo(String value) {
            addCriterion("roam_type <=", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeLike(String value) {
            addCriterion("roam_type like", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeNotLike(String value) {
            addCriterion("roam_type not like", value, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeIn(List<String> values) {
            addCriterion("roam_type in", values, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeNotIn(List<String> values) {
            addCriterion("roam_type not in", values, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeBetween(String value1, String value2) {
            addCriterion("roam_type between", value1, value2, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamTypeNotBetween(String value1, String value2) {
            addCriterion("roam_type not between", value1, value2, "roamType");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowIsNull() {
            addCriterion("roam_ismodelshow is null");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowIsNotNull() {
            addCriterion("roam_ismodelshow is not null");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowEqualTo(String value) {
            addCriterion("roam_ismodelshow =", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowNotEqualTo(String value) {
            addCriterion("roam_ismodelshow <>", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowGreaterThan(String value) {
            addCriterion("roam_ismodelshow >", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowGreaterThanOrEqualTo(String value) {
            addCriterion("roam_ismodelshow >=", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowLessThan(String value) {
            addCriterion("roam_ismodelshow <", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowLessThanOrEqualTo(String value) {
            addCriterion("roam_ismodelshow <=", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowLike(String value) {
            addCriterion("roam_ismodelshow like", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowNotLike(String value) {
            addCriterion("roam_ismodelshow not like", value, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowIn(List<String> values) {
            addCriterion("roam_ismodelshow in", values, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowNotIn(List<String> values) {
            addCriterion("roam_ismodelshow not in", values, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowBetween(String value1, String value2) {
            addCriterion("roam_ismodelshow between", value1, value2, "roamIsmodelshow");
            return (Criteria) this;
        }

        public Criteria andRoamIsmodelshowNotBetween(String value1, String value2) {
            addCriterion("roam_ismodelshow not between", value1, value2, "roamIsmodelshow");
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