/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.deaceased as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.deaceased;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.phys.Vec3;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerLevelRelatedUtils {
    public static <T extends ParticleOptions> void sendParticles(ServerLevel serverLevel, T particleOptions, double posX, double posY, double posZ, int particleCount, double randX, double randY, double randZ, double randSpeed) {
        ClientboundLevelParticlesPacket clientboundlevelparticlespacket = new ClientboundLevelParticlesPacket(particleOptions, true, posX, posY, posZ, (float) randX, (float) randY, (float) randZ, (float) randSpeed, particleCount);
        for (int j = 0; j < serverLevel.players().size(); ++j) {
            ServerPlayer serverplayer = serverLevel.players().get(j);
            sendParticles(serverLevel, serverplayer, posX, posY, posZ, clientboundlevelparticlespacket);
        }
    }

    public static boolean sendParticles(ServerLevel serverLevel, ServerPlayer serverPlayer, double posX, double posY, double posZ, Packet<?> clientboundlevelparticlespacket) {
        if (serverPlayer.level() != serverLevel) {
            return false;
        } else {
            BlockPos blockpos = serverPlayer.blockPosition();
            if (blockpos.closerToCenterThan(new Vec3(posX, posY, posZ), 128.0D/*This 512 means the render distance of the particles*/)) {
                serverPlayer.connection.send(clientboundlevelparticlespacket);
                return true;
            } else {
                return false;
            }
        }
    }
}