// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class skulkpig extends EntityModel<Entity> {
	private final ModelPart nogi;
	private final ModelPart lewy dol prawa gura;
	private final ModelPart drugia;
	private final ModelPart bb_main;
	public skulkpig(ModelPart root) {
		this.nogi = root.getChild("nogi");
		this.lewy dol prawa gura = root.getChild("lewy dol prawa gura");
		this.drugia = root.getChild("drugia");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData nogi = modelPartData.addChild("nogi", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 24.0F, 0.0F));

		ModelPartData lewy dol prawa gura = modelPartData.addChild("lewy dol prawa gura", ModelPartBuilder.create().uv(8, 28).cuboid(2.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 16).cuboid(-4.0F, -5.0F, -8.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData drugia = modelPartData.addChild("drugia", ModelPartBuilder.create().uv(0, 28).cuboid(2.0F, -5.0F, -8.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 23).cuboid(-4.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -11.0F, -8.0F, 8.0F, 6.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-3.0F, -15.0F, 0.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		nogi.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		lewy dol prawa gura.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		drugia.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}