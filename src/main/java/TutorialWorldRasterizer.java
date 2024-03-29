/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.terasology.math.ChunkMath;
import org.terasology.math.geom.Vector3i;
import org.terasology.registry.CoreRegistry;
import org.terasology.world.block.Block;
import org.terasology.world.block.BlockManager;
import org.terasology.world.chunks.CoreChunk;
import org.terasology.world.generation.Region;
import org.terasology.world.generation.WorldRasterizer;
import org.terasology.world.generation.facets.SurfaceHeightFacet;
import org.terasology.world.generation.facets.base.BaseBooleanFieldFacet2D;

public class TutorialWorldRasterizer implements WorldRasterizer {
    private Block dirt;
    @Override
    public void initialize(){
        dirt = CoreRegistry.get(BlockManager.class).getBlock("CoreBlocks:Dirt");
    }

    @Override
    public void generateChunk(CoreChunk chunk, Region chunkRegion){
        for(Vector3i position:chunkRegion.getRegion()){
            SurfaceHeightFacet surfaceHeightFacet=chunkRegion.getFacet(SurfaceHeightFacet.class);
            float surfaceHeight=surfaceHeightFacet.getWorld(position.x,position.z);
            if(position.y < surfaceHeight){
                chunk.setBlock(ChunkMath.calcBlockPos(position), dirt);
            }
        }
    }
}
