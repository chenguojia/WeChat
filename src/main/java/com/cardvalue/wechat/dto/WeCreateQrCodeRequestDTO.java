package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class WeCreateQrCodeRequestDTO {

	@JsonProperty("expire_seconds")
	private int expireSeconds;
	
	@JsonProperty("action_name")
	private String actionName;
	
	@JsonProperty("action_info")
	private ActionInfo actionInfo = new ActionInfo();
	
	public class ActionInfo{
		@JsonProperty("scene")
		private Scene scene = new Scene();

		public Scene getScene() {
			return scene;
		}

		public void setScene(Scene scene) {
			this.scene = scene;
		}
		
	} 
	
	public class Scene{
		@JsonProperty("scene_id")
		private long sceneId;

		public long getSceneId() {
			return sceneId;
		}

		public void setSceneId(long sceneId) {
			this.sceneId = sceneId;
		}
		
	}

	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
	
}
