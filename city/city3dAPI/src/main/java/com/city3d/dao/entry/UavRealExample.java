package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class UavRealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UavRealExample() {
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

        public Criteria andRealIdIsNull() {
            addCriterion("real_id is null");
            return (Criteria) this;
        }

        public Criteria andRealIdIsNotNull() {
            addCriterion("real_id is not null");
            return (Criteria) this;
        }

        public Criteria andRealIdEqualTo(String value) {
            addCriterion("real_id =", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotEqualTo(String value) {
            addCriterion("real_id <>", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThan(String value) {
            addCriterion("real_id >", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThanOrEqualTo(String value) {
            addCriterion("real_id >=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThan(String value) {
            addCriterion("real_id <", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThanOrEqualTo(String value) {
            addCriterion("real_id <=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLike(String value) {
            addCriterion("real_id like", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotLike(String value) {
            addCriterion("real_id not like", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdIn(List<String> values) {
            addCriterion("real_id in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotIn(List<String> values) {
            addCriterion("real_id not in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdBetween(String value1, String value2) {
            addCriterion("real_id between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotBetween(String value1, String value2) {
            addCriterion("real_id not between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andYawValueIsNull() {
            addCriterion("yaw_value is null");
            return (Criteria) this;
        }

        public Criteria andYawValueIsNotNull() {
            addCriterion("yaw_value is not null");
            return (Criteria) this;
        }

        public Criteria andYawValueEqualTo(String value) {
            addCriterion("yaw_value =", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueNotEqualTo(String value) {
            addCriterion("yaw_value <>", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueGreaterThan(String value) {
            addCriterion("yaw_value >", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueGreaterThanOrEqualTo(String value) {
            addCriterion("yaw_value >=", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueLessThan(String value) {
            addCriterion("yaw_value <", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueLessThanOrEqualTo(String value) {
            addCriterion("yaw_value <=", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueLike(String value) {
            addCriterion("yaw_value like", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueNotLike(String value) {
            addCriterion("yaw_value not like", value, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueIn(List<String> values) {
            addCriterion("yaw_value in", values, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueNotIn(List<String> values) {
            addCriterion("yaw_value not in", values, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueBetween(String value1, String value2) {
            addCriterion("yaw_value between", value1, value2, "yawValue");
            return (Criteria) this;
        }

        public Criteria andYawValueNotBetween(String value1, String value2) {
            addCriterion("yaw_value not between", value1, value2, "yawValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueIsNull() {
            addCriterion("pitch_value is null");
            return (Criteria) this;
        }

        public Criteria andPitchValueIsNotNull() {
            addCriterion("pitch_value is not null");
            return (Criteria) this;
        }

        public Criteria andPitchValueEqualTo(String value) {
            addCriterion("pitch_value =", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueNotEqualTo(String value) {
            addCriterion("pitch_value <>", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueGreaterThan(String value) {
            addCriterion("pitch_value >", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueGreaterThanOrEqualTo(String value) {
            addCriterion("pitch_value >=", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueLessThan(String value) {
            addCriterion("pitch_value <", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueLessThanOrEqualTo(String value) {
            addCriterion("pitch_value <=", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueLike(String value) {
            addCriterion("pitch_value like", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueNotLike(String value) {
            addCriterion("pitch_value not like", value, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueIn(List<String> values) {
            addCriterion("pitch_value in", values, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueNotIn(List<String> values) {
            addCriterion("pitch_value not in", values, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueBetween(String value1, String value2) {
            addCriterion("pitch_value between", value1, value2, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andPitchValueNotBetween(String value1, String value2) {
            addCriterion("pitch_value not between", value1, value2, "pitchValue");
            return (Criteria) this;
        }

        public Criteria andRollValueIsNull() {
            addCriterion("roll_value is null");
            return (Criteria) this;
        }

        public Criteria andRollValueIsNotNull() {
            addCriterion("roll_value is not null");
            return (Criteria) this;
        }

        public Criteria andRollValueEqualTo(String value) {
            addCriterion("roll_value =", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueNotEqualTo(String value) {
            addCriterion("roll_value <>", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueGreaterThan(String value) {
            addCriterion("roll_value >", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueGreaterThanOrEqualTo(String value) {
            addCriterion("roll_value >=", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueLessThan(String value) {
            addCriterion("roll_value <", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueLessThanOrEqualTo(String value) {
            addCriterion("roll_value <=", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueLike(String value) {
            addCriterion("roll_value like", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueNotLike(String value) {
            addCriterion("roll_value not like", value, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueIn(List<String> values) {
            addCriterion("roll_value in", values, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueNotIn(List<String> values) {
            addCriterion("roll_value not in", values, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueBetween(String value1, String value2) {
            addCriterion("roll_value between", value1, value2, "rollValue");
            return (Criteria) this;
        }

        public Criteria andRollValueNotBetween(String value1, String value2) {
            addCriterion("roll_value not between", value1, value2, "rollValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueIsNull() {
            addCriterion("batter_value is null");
            return (Criteria) this;
        }

        public Criteria andBatterValueIsNotNull() {
            addCriterion("batter_value is not null");
            return (Criteria) this;
        }

        public Criteria andBatterValueEqualTo(String value) {
            addCriterion("batter_value =", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueNotEqualTo(String value) {
            addCriterion("batter_value <>", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueGreaterThan(String value) {
            addCriterion("batter_value >", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueGreaterThanOrEqualTo(String value) {
            addCriterion("batter_value >=", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueLessThan(String value) {
            addCriterion("batter_value <", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueLessThanOrEqualTo(String value) {
            addCriterion("batter_value <=", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueLike(String value) {
            addCriterion("batter_value like", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueNotLike(String value) {
            addCriterion("batter_value not like", value, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueIn(List<String> values) {
            addCriterion("batter_value in", values, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueNotIn(List<String> values) {
            addCriterion("batter_value not in", values, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueBetween(String value1, String value2) {
            addCriterion("batter_value between", value1, value2, "batterValue");
            return (Criteria) this;
        }

        public Criteria andBatterValueNotBetween(String value1, String value2) {
            addCriterion("batter_value not between", value1, value2, "batterValue");
            return (Criteria) this;
        }

        public Criteria andFlyStateIsNull() {
            addCriterion("fly_state is null");
            return (Criteria) this;
        }

        public Criteria andFlyStateIsNotNull() {
            addCriterion("fly_state is not null");
            return (Criteria) this;
        }

        public Criteria andFlyStateEqualTo(String value) {
            addCriterion("fly_state =", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateNotEqualTo(String value) {
            addCriterion("fly_state <>", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateGreaterThan(String value) {
            addCriterion("fly_state >", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateGreaterThanOrEqualTo(String value) {
            addCriterion("fly_state >=", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateLessThan(String value) {
            addCriterion("fly_state <", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateLessThanOrEqualTo(String value) {
            addCriterion("fly_state <=", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateLike(String value) {
            addCriterion("fly_state like", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateNotLike(String value) {
            addCriterion("fly_state not like", value, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateIn(List<String> values) {
            addCriterion("fly_state in", values, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateNotIn(List<String> values) {
            addCriterion("fly_state not in", values, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateBetween(String value1, String value2) {
            addCriterion("fly_state between", value1, value2, "flyState");
            return (Criteria) this;
        }

        public Criteria andFlyStateNotBetween(String value1, String value2) {
            addCriterion("fly_state not between", value1, value2, "flyState");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnIsNull() {
            addCriterion("is_video_on is null");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnIsNotNull() {
            addCriterion("is_video_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnEqualTo(Boolean value) {
            addCriterion("is_video_on =", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnNotEqualTo(Boolean value) {
            addCriterion("is_video_on <>", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnGreaterThan(Boolean value) {
            addCriterion("is_video_on >", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_video_on >=", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnLessThan(Boolean value) {
            addCriterion("is_video_on <", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnLessThanOrEqualTo(Boolean value) {
            addCriterion("is_video_on <=", value, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnIn(List<Boolean> values) {
            addCriterion("is_video_on in", values, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnNotIn(List<Boolean> values) {
            addCriterion("is_video_on not in", values, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnBetween(Boolean value1, Boolean value2) {
            addCriterion("is_video_on between", value1, value2, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andIsVideoOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_video_on not between", value1, value2, "isVideoOn");
            return (Criteria) this;
        }

        public Criteria andCYamIsNull() {
            addCriterion("c_yam is null");
            return (Criteria) this;
        }

        public Criteria andCYamIsNotNull() {
            addCriterion("c_yam is not null");
            return (Criteria) this;
        }

        public Criteria andCYamEqualTo(String value) {
            addCriterion("c_yam =", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamNotEqualTo(String value) {
            addCriterion("c_yam <>", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamGreaterThan(String value) {
            addCriterion("c_yam >", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamGreaterThanOrEqualTo(String value) {
            addCriterion("c_yam >=", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamLessThan(String value) {
            addCriterion("c_yam <", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamLessThanOrEqualTo(String value) {
            addCriterion("c_yam <=", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamLike(String value) {
            addCriterion("c_yam like", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamNotLike(String value) {
            addCriterion("c_yam not like", value, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamIn(List<String> values) {
            addCriterion("c_yam in", values, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamNotIn(List<String> values) {
            addCriterion("c_yam not in", values, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamBetween(String value1, String value2) {
            addCriterion("c_yam between", value1, value2, "cYam");
            return (Criteria) this;
        }

        public Criteria andCYamNotBetween(String value1, String value2) {
            addCriterion("c_yam not between", value1, value2, "cYam");
            return (Criteria) this;
        }

        public Criteria andCPitchIsNull() {
            addCriterion("c_pitch is null");
            return (Criteria) this;
        }

        public Criteria andCPitchIsNotNull() {
            addCriterion("c_pitch is not null");
            return (Criteria) this;
        }

        public Criteria andCPitchEqualTo(String value) {
            addCriterion("c_pitch =", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchNotEqualTo(String value) {
            addCriterion("c_pitch <>", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchGreaterThan(String value) {
            addCriterion("c_pitch >", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchGreaterThanOrEqualTo(String value) {
            addCriterion("c_pitch >=", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchLessThan(String value) {
            addCriterion("c_pitch <", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchLessThanOrEqualTo(String value) {
            addCriterion("c_pitch <=", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchLike(String value) {
            addCriterion("c_pitch like", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchNotLike(String value) {
            addCriterion("c_pitch not like", value, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchIn(List<String> values) {
            addCriterion("c_pitch in", values, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchNotIn(List<String> values) {
            addCriterion("c_pitch not in", values, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchBetween(String value1, String value2) {
            addCriterion("c_pitch between", value1, value2, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCPitchNotBetween(String value1, String value2) {
            addCriterion("c_pitch not between", value1, value2, "cPitch");
            return (Criteria) this;
        }

        public Criteria andCRollIsNull() {
            addCriterion("c_roll is null");
            return (Criteria) this;
        }

        public Criteria andCRollIsNotNull() {
            addCriterion("c_roll is not null");
            return (Criteria) this;
        }

        public Criteria andCRollEqualTo(String value) {
            addCriterion("c_roll =", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollNotEqualTo(String value) {
            addCriterion("c_roll <>", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollGreaterThan(String value) {
            addCriterion("c_roll >", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollGreaterThanOrEqualTo(String value) {
            addCriterion("c_roll >=", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollLessThan(String value) {
            addCriterion("c_roll <", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollLessThanOrEqualTo(String value) {
            addCriterion("c_roll <=", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollLike(String value) {
            addCriterion("c_roll like", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollNotLike(String value) {
            addCriterion("c_roll not like", value, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollIn(List<String> values) {
            addCriterion("c_roll in", values, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollNotIn(List<String> values) {
            addCriterion("c_roll not in", values, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollBetween(String value1, String value2) {
            addCriterion("c_roll between", value1, value2, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCRollNotBetween(String value1, String value2) {
            addCriterion("c_roll not between", value1, value2, "cRoll");
            return (Criteria) this;
        }

        public Criteria andCamFovIsNull() {
            addCriterion("cam_fov is null");
            return (Criteria) this;
        }

        public Criteria andCamFovIsNotNull() {
            addCriterion("cam_fov is not null");
            return (Criteria) this;
        }

        public Criteria andCamFovEqualTo(String value) {
            addCriterion("cam_fov =", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotEqualTo(String value) {
            addCriterion("cam_fov <>", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovGreaterThan(String value) {
            addCriterion("cam_fov >", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovGreaterThanOrEqualTo(String value) {
            addCriterion("cam_fov >=", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLessThan(String value) {
            addCriterion("cam_fov <", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLessThanOrEqualTo(String value) {
            addCriterion("cam_fov <=", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLike(String value) {
            addCriterion("cam_fov like", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotLike(String value) {
            addCriterion("cam_fov not like", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovIn(List<String> values) {
            addCriterion("cam_fov in", values, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotIn(List<String> values) {
            addCriterion("cam_fov not in", values, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovBetween(String value1, String value2) {
            addCriterion("cam_fov between", value1, value2, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotBetween(String value1, String value2) {
            addCriterion("cam_fov not between", value1, value2, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamNearIsNull() {
            addCriterion("cam_near is null");
            return (Criteria) this;
        }

        public Criteria andCamNearIsNotNull() {
            addCriterion("cam_near is not null");
            return (Criteria) this;
        }

        public Criteria andCamNearEqualTo(String value) {
            addCriterion("cam_near =", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotEqualTo(String value) {
            addCriterion("cam_near <>", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearGreaterThan(String value) {
            addCriterion("cam_near >", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearGreaterThanOrEqualTo(String value) {
            addCriterion("cam_near >=", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLessThan(String value) {
            addCriterion("cam_near <", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLessThanOrEqualTo(String value) {
            addCriterion("cam_near <=", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLike(String value) {
            addCriterion("cam_near like", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotLike(String value) {
            addCriterion("cam_near not like", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearIn(List<String> values) {
            addCriterion("cam_near in", values, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotIn(List<String> values) {
            addCriterion("cam_near not in", values, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearBetween(String value1, String value2) {
            addCriterion("cam_near between", value1, value2, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotBetween(String value1, String value2) {
            addCriterion("cam_near not between", value1, value2, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamFarIsNull() {
            addCriterion("cam_far is null");
            return (Criteria) this;
        }

        public Criteria andCamFarIsNotNull() {
            addCriterion("cam_far is not null");
            return (Criteria) this;
        }

        public Criteria andCamFarEqualTo(String value) {
            addCriterion("cam_far =", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotEqualTo(String value) {
            addCriterion("cam_far <>", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarGreaterThan(String value) {
            addCriterion("cam_far >", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarGreaterThanOrEqualTo(String value) {
            addCriterion("cam_far >=", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLessThan(String value) {
            addCriterion("cam_far <", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLessThanOrEqualTo(String value) {
            addCriterion("cam_far <=", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLike(String value) {
            addCriterion("cam_far like", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotLike(String value) {
            addCriterion("cam_far not like", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarIn(List<String> values) {
            addCriterion("cam_far in", values, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotIn(List<String> values) {
            addCriterion("cam_far not in", values, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarBetween(String value1, String value2) {
            addCriterion("cam_far between", value1, value2, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotBetween(String value1, String value2) {
            addCriterion("cam_far not between", value1, value2, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIsNull() {
            addCriterion("cam_aspectratio is null");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIsNotNull() {
            addCriterion("cam_aspectratio is not null");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioEqualTo(String value) {
            addCriterion("cam_aspectratio =", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotEqualTo(String value) {
            addCriterion("cam_aspectratio <>", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioGreaterThan(String value) {
            addCriterion("cam_aspectratio >", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioGreaterThanOrEqualTo(String value) {
            addCriterion("cam_aspectratio >=", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLessThan(String value) {
            addCriterion("cam_aspectratio <", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLessThanOrEqualTo(String value) {
            addCriterion("cam_aspectratio <=", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLike(String value) {
            addCriterion("cam_aspectratio like", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotLike(String value) {
            addCriterion("cam_aspectratio not like", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIn(List<String> values) {
            addCriterion("cam_aspectratio in", values, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotIn(List<String> values) {
            addCriterion("cam_aspectratio not in", values, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioBetween(String value1, String value2) {
            addCriterion("cam_aspectratio between", value1, value2, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotBetween(String value1, String value2) {
            addCriterion("cam_aspectratio not between", value1, value2, "camAspectratio");
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

        public Criteria andRealDateIsNull() {
            addCriterion("real_date is null");
            return (Criteria) this;
        }

        public Criteria andRealDateIsNotNull() {
            addCriterion("real_date is not null");
            return (Criteria) this;
        }

        public Criteria andRealDateEqualTo(String value) {
            addCriterion("real_date =", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateNotEqualTo(String value) {
            addCriterion("real_date <>", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateGreaterThan(String value) {
            addCriterion("real_date >", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateGreaterThanOrEqualTo(String value) {
            addCriterion("real_date >=", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateLessThan(String value) {
            addCriterion("real_date <", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateLessThanOrEqualTo(String value) {
            addCriterion("real_date <=", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateLike(String value) {
            addCriterion("real_date like", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateNotLike(String value) {
            addCriterion("real_date not like", value, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateIn(List<String> values) {
            addCriterion("real_date in", values, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateNotIn(List<String> values) {
            addCriterion("real_date not in", values, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateBetween(String value1, String value2) {
            addCriterion("real_date between", value1, value2, "realDate");
            return (Criteria) this;
        }

        public Criteria andRealDateNotBetween(String value1, String value2) {
            addCriterion("real_date not between", value1, value2, "realDate");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngIsNull() {
            addCriterion("drone_location_lng is null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngIsNotNull() {
            addCriterion("drone_location_lng is not null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngEqualTo(String value) {
            addCriterion("drone_location_lng =", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngNotEqualTo(String value) {
            addCriterion("drone_location_lng <>", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngGreaterThan(String value) {
            addCriterion("drone_location_lng >", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngGreaterThanOrEqualTo(String value) {
            addCriterion("drone_location_lng >=", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngLessThan(String value) {
            addCriterion("drone_location_lng <", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngLessThanOrEqualTo(String value) {
            addCriterion("drone_location_lng <=", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngLike(String value) {
            addCriterion("drone_location_lng like", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngNotLike(String value) {
            addCriterion("drone_location_lng not like", value, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngIn(List<String> values) {
            addCriterion("drone_location_lng in", values, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngNotIn(List<String> values) {
            addCriterion("drone_location_lng not in", values, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngBetween(String value1, String value2) {
            addCriterion("drone_location_lng between", value1, value2, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLngNotBetween(String value1, String value2) {
            addCriterion("drone_location_lng not between", value1, value2, "droneLocationLng");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatIsNull() {
            addCriterion("drone_location_lat is null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatIsNotNull() {
            addCriterion("drone_location_lat is not null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatEqualTo(String value) {
            addCriterion("drone_location_lat =", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatNotEqualTo(String value) {
            addCriterion("drone_location_lat <>", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatGreaterThan(String value) {
            addCriterion("drone_location_lat >", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatGreaterThanOrEqualTo(String value) {
            addCriterion("drone_location_lat >=", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatLessThan(String value) {
            addCriterion("drone_location_lat <", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatLessThanOrEqualTo(String value) {
            addCriterion("drone_location_lat <=", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatLike(String value) {
            addCriterion("drone_location_lat like", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatNotLike(String value) {
            addCriterion("drone_location_lat not like", value, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatIn(List<String> values) {
            addCriterion("drone_location_lat in", values, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatNotIn(List<String> values) {
            addCriterion("drone_location_lat not in", values, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatBetween(String value1, String value2) {
            addCriterion("drone_location_lat between", value1, value2, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationLatNotBetween(String value1, String value2) {
            addCriterion("drone_location_lat not between", value1, value2, "droneLocationLat");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtIsNull() {
            addCriterion("drone_location_art is null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtIsNotNull() {
            addCriterion("drone_location_art is not null");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtEqualTo(String value) {
            addCriterion("drone_location_art =", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtNotEqualTo(String value) {
            addCriterion("drone_location_art <>", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtGreaterThan(String value) {
            addCriterion("drone_location_art >", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtGreaterThanOrEqualTo(String value) {
            addCriterion("drone_location_art >=", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtLessThan(String value) {
            addCriterion("drone_location_art <", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtLessThanOrEqualTo(String value) {
            addCriterion("drone_location_art <=", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtLike(String value) {
            addCriterion("drone_location_art like", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtNotLike(String value) {
            addCriterion("drone_location_art not like", value, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtIn(List<String> values) {
            addCriterion("drone_location_art in", values, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtNotIn(List<String> values) {
            addCriterion("drone_location_art not in", values, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtBetween(String value1, String value2) {
            addCriterion("drone_location_art between", value1, value2, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andDroneLocationArtNotBetween(String value1, String value2) {
            addCriterion("drone_location_art not between", value1, value2, "droneLocationArt");
            return (Criteria) this;
        }

        public Criteria andVelocityXIsNull() {
            addCriterion("velocity_x is null");
            return (Criteria) this;
        }

        public Criteria andVelocityXIsNotNull() {
            addCriterion("velocity_x is not null");
            return (Criteria) this;
        }

        public Criteria andVelocityXEqualTo(String value) {
            addCriterion("velocity_x =", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXNotEqualTo(String value) {
            addCriterion("velocity_x <>", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXGreaterThan(String value) {
            addCriterion("velocity_x >", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXGreaterThanOrEqualTo(String value) {
            addCriterion("velocity_x >=", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXLessThan(String value) {
            addCriterion("velocity_x <", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXLessThanOrEqualTo(String value) {
            addCriterion("velocity_x <=", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXLike(String value) {
            addCriterion("velocity_x like", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXNotLike(String value) {
            addCriterion("velocity_x not like", value, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXIn(List<String> values) {
            addCriterion("velocity_x in", values, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXNotIn(List<String> values) {
            addCriterion("velocity_x not in", values, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXBetween(String value1, String value2) {
            addCriterion("velocity_x between", value1, value2, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityXNotBetween(String value1, String value2) {
            addCriterion("velocity_x not between", value1, value2, "velocityX");
            return (Criteria) this;
        }

        public Criteria andVelocityYIsNull() {
            addCriterion("velocity_y is null");
            return (Criteria) this;
        }

        public Criteria andVelocityYIsNotNull() {
            addCriterion("velocity_y is not null");
            return (Criteria) this;
        }

        public Criteria andVelocityYEqualTo(String value) {
            addCriterion("velocity_y =", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYNotEqualTo(String value) {
            addCriterion("velocity_y <>", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYGreaterThan(String value) {
            addCriterion("velocity_y >", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYGreaterThanOrEqualTo(String value) {
            addCriterion("velocity_y >=", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYLessThan(String value) {
            addCriterion("velocity_y <", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYLessThanOrEqualTo(String value) {
            addCriterion("velocity_y <=", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYLike(String value) {
            addCriterion("velocity_y like", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYNotLike(String value) {
            addCriterion("velocity_y not like", value, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYIn(List<String> values) {
            addCriterion("velocity_y in", values, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYNotIn(List<String> values) {
            addCriterion("velocity_y not in", values, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYBetween(String value1, String value2) {
            addCriterion("velocity_y between", value1, value2, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityYNotBetween(String value1, String value2) {
            addCriterion("velocity_y not between", value1, value2, "velocityY");
            return (Criteria) this;
        }

        public Criteria andVelocityZIsNull() {
            addCriterion("velocity_z is null");
            return (Criteria) this;
        }

        public Criteria andVelocityZIsNotNull() {
            addCriterion("velocity_z is not null");
            return (Criteria) this;
        }

        public Criteria andVelocityZEqualTo(String value) {
            addCriterion("velocity_z =", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZNotEqualTo(String value) {
            addCriterion("velocity_z <>", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZGreaterThan(String value) {
            addCriterion("velocity_z >", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZGreaterThanOrEqualTo(String value) {
            addCriterion("velocity_z >=", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZLessThan(String value) {
            addCriterion("velocity_z <", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZLessThanOrEqualTo(String value) {
            addCriterion("velocity_z <=", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZLike(String value) {
            addCriterion("velocity_z like", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZNotLike(String value) {
            addCriterion("velocity_z not like", value, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZIn(List<String> values) {
            addCriterion("velocity_z in", values, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZNotIn(List<String> values) {
            addCriterion("velocity_z not in", values, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZBetween(String value1, String value2) {
            addCriterion("velocity_z between", value1, value2, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andVelocityZNotBetween(String value1, String value2) {
            addCriterion("velocity_z not between", value1, value2, "velocityZ");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountIsNull() {
            addCriterion("satellite_count is null");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountIsNotNull() {
            addCriterion("satellite_count is not null");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountEqualTo(String value) {
            addCriterion("satellite_count =", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountNotEqualTo(String value) {
            addCriterion("satellite_count <>", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountGreaterThan(String value) {
            addCriterion("satellite_count >", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountGreaterThanOrEqualTo(String value) {
            addCriterion("satellite_count >=", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountLessThan(String value) {
            addCriterion("satellite_count <", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountLessThanOrEqualTo(String value) {
            addCriterion("satellite_count <=", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountLike(String value) {
            addCriterion("satellite_count like", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountNotLike(String value) {
            addCriterion("satellite_count not like", value, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountIn(List<String> values) {
            addCriterion("satellite_count in", values, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountNotIn(List<String> values) {
            addCriterion("satellite_count not in", values, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountBetween(String value1, String value2) {
            addCriterion("satellite_count between", value1, value2, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andSatelliteCountNotBetween(String value1, String value2) {
            addCriterion("satellite_count not between", value1, value2, "satelliteCount");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsIsNull() {
            addCriterion("flight_time_in_seconds is null");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsIsNotNull() {
            addCriterion("flight_time_in_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsEqualTo(String value) {
            addCriterion("flight_time_in_seconds =", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsNotEqualTo(String value) {
            addCriterion("flight_time_in_seconds <>", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsGreaterThan(String value) {
            addCriterion("flight_time_in_seconds >", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsGreaterThanOrEqualTo(String value) {
            addCriterion("flight_time_in_seconds >=", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsLessThan(String value) {
            addCriterion("flight_time_in_seconds <", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsLessThanOrEqualTo(String value) {
            addCriterion("flight_time_in_seconds <=", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsLike(String value) {
            addCriterion("flight_time_in_seconds like", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsNotLike(String value) {
            addCriterion("flight_time_in_seconds not like", value, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsIn(List<String> values) {
            addCriterion("flight_time_in_seconds in", values, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsNotIn(List<String> values) {
            addCriterion("flight_time_in_seconds not in", values, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsBetween(String value1, String value2) {
            addCriterion("flight_time_in_seconds between", value1, value2, "flightTimeInSeconds");
            return (Criteria) this;
        }

        public Criteria andFlightTimeInSecondsNotBetween(String value1, String value2) {
            addCriterion("flight_time_in_seconds not between", value1, value2, "flightTimeInSeconds");
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