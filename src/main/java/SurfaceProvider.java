import org.terasology.world.generation.FacetProvider;
import org.terasology.world.generation.GeneratingRegion;
import org.terasology.world.generation.Produces;
import org.terasology.world.generation.facets.SurfaceHeightFacet;
import org.terasology.world.viewer.layers.engine.SurfaceHeightFacetLayer;

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
@Produces(SurfaceHeightFacet.class)
public class SurfaceProvider implements FacetProvider {
    @Override
    public void setSeed(long seed){

    }
    @Override
    public void process(GeneratingRegion region){
   Border3D border=region.getRegionFacet(SurfaceHeightFacet.class);
        SurfaceHeightFacetLayer facet=new SurfaceHeightFacet(region.getRegion(),border);
        Rect2i processRegion=facet.getWorldRegion();
        facet.setWorld(position,10f);
        region.setRegionFacet(SurfaceHeightFacet.class,facet);
    }

}
