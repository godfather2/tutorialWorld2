import org.terasology.world.generation.WorldRasterizer;

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
public class TutorialWorldRasterizer implements WorldRasterizer {
    @Override
    public void initialize(){

    }
    @Override
    public void generateChunk(CoreChunk chunk,Region chunkRegion){
   for(Vector3i position:chunkRegion.getRegion()){
       if(position.y<0){
           chunk.setBlock(ChunkMath.calcBlockPos(position),dirt);
       }
   }
    }
}
